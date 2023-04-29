// 执行分页，生成页面效果，任何时候调用这个函数都会重新加载页面
function generatePage() {
    // 1.获取分页数据
    var pageInfo = getPageInfoRemote();
    // 2.填充表格
    fillTableBody(pageInfo);
    // 生成分页导航条
    js_method(pageInfo);
}

//初始化页面的一些事件
function init() {
    var rolePageBody = $(".rolePageBody");
    // 表单全选全不选
    $("#allRoleBox").click(function () {
        $(".roleBox").prop("checked", this.checked);
    });

    // 下面单选框判断
    rolePageBody.on("click", ".roleBox", function () {
        if ($(".roleBox").length === $(".roleBox:checked").length) {
            $("#allRoleBox").prop("checked", true);
        } else {
            $("#allRoleBox").prop("checked", false);
        }
    });


    // 关键词查询
    $("#keywordBtn").click(function () {
        // 关键词 赋给全局变量 keyword
        keyword = $.trim($("#keyword").val());
        if (keyword === undefined || keyword === "" || keyword.length === 0) {
            layer.msg("请输入关键词！");
            return;
        }
        generatePage();
    });

    //显示 新增 模态框
    $("#showAddModal").click(function () {
        // 清空输入框
        $("#role-add [name=roleName]").val("");
        // 显示
        $("#role-add").modal("show");
    });


    //显示 更新 模态框
    rolePageBody.on("click", "#showUpdateModal", function () {
        $("#role-update").modal("show");
        // roleId 给下一步提交数据库使用
        roleId = $(this).parent().prev().prev().prev().text();
        // 回显 roleName 到文本框
        var roleName = $(this).parent().prev().text();
        $("#role-update [name=roleName]").val(roleName);
    });

    //显示 删除 模态框 单删
    rolePageBody.on("click", "#showDeleteModal", function () {
        // 清空全局数组
        roleArray = [];
        // 获取当前要删除的 role 然后存入数组
        var role = {
            id: $(this).parent().prev().prev().prev().text(),
            name: $(this).parent().prev().text()
        }
        roleArray.push(role);
        // 渲染 删除 模态框
        showDeleteModal();
    });

    // 显示 删除 模态框 批量删
    $("#btn-delete").click(function () {
        // 清空全局数组
        roleArray = [];
        var roleBox = $(".roleBox:checked");
        if (roleBox.length === 0) {
            layer.msg("请先选择要删除的权限！");
            return;
        }
        // 把勾选了复选框的 role 存入数组
        roleBox.each(function () {
            roleArray.push({
                id: $(this).parent().prev().text(),
                name: $(this).parent().next().text()
            });
        });
        // 渲染 删除 模态框
        showDeleteModal();
    });


    // 显示 角色权限配置 模态框
    rolePageBody.on("click", "#showAssignModal", function () {
        // 把当前角色 id 保存到全局变量
        roleId = $(this).parent().siblings("td").eq(0).text();
        // 生成 角色权限配置 结构树
        fillAuthTree();
        // 显示模态框
        $("#assign-role").modal("show");
    });


    // 绑定保存按钮
    $("#saveRole").click(function () {
        // 向服务器保存
        saveRole();
    });

    // 绑定更新按钮
    $("#updateRole").click(function () {
        //向服务器更新数据
        updateRole();
    });

    // 绑定删除按钮
    $("#deleteRole").click(function () {
        //向服务器更新数据
        deleteRole();
    });

    // 绑定 角色权限配置 保存按钮
    $("#assignRole").click(function () {
        //向服务器更新数据
        saveAssign();
    });

}

/**
 * 向服务器请求删除
 */
function deleteRole() {
    var ids = [];
    for (const role of roleArray) {
        ids.push(role.id);
    }
    // 序列化数组
    var data = JSON.stringify(ids)
    // 向服务器发送请求
    deleteRoleAjax(data);
    // 关闭模态框
    $("#role-delete").modal("hide");
}


/**
 * 渲染 删除 模态框
 */
function showDeleteModal() {
    $("#role-delete [class=modal-body]").empty();
    $("#role-delete").modal("show");
    for (const role of roleArray) {
        $("#role-delete [class=modal-body]").append("<h5>" + role.name + "</h5>");
    }
}

/**
 * 准备向服务器保存数据
 */
function saveRole() {
    var roleName = $.trim($("#role-add [name=roleName]").val());
    // Ajax 配置
    var data = {
        "name": roleName
    };

    // roleName 检查，然后向服务器发送数据
    roleNameCheck(data);
    // 关闭模态框
    $("#role-add").modal("hide");

}

/**
 * 向服务器更新数据
 */
function updateRole() {
    var roleName = $.trim($("#role-update [name=roleName]").val());
    // Ajax 配置
    var data = {
        "id": roleId,
        "name": roleName,
        "_method": "PUT"
    };
    // roleName 检查，然后向服务器发送数据
    roleNameCheck(data);
    // 关闭模态框
    $("#role-update").modal("hide");
}

/**
 * 添加和更新的 roleName 校验
 */
function roleNameCheck(data) {
    if (data.name === undefined || data.name === "" || data.name.length === 0) {
        layer.msg("请输入要更新的权限！");
        return;
    }
    roleAjax(data);
}


/**
 * 增 改 Ajax
 */
function roleAjax(data) {
    $.ajax({
        "url": url,
        "type": "post",
        "data": data,
        "dataType": "json",
        "success": function (response) {
            var result = response.result;
            if (result === "SUCCESS") {
                layer.msg("操作成功！");
                // 重新加载分页数据
                if (data._method === undefined) {
                    // 如果是添加操作 跳转的最后一页
                    pageNum = 999999;
                }
                generatePage();
            }
            if (result === "FAILED") {
                layer.msg("操作失败！" + response.message);
            }
        }, "error": function (response) {
            layer.msg(response.status + " " + response.statusText);
        }
    });
}

/**
 * 删 Ajax
 */
function deleteRoleAjax(data) {
    $.ajax({
        "url": url + "?_method=delete",
        "type": "post",
        "contentType": "application/json;charset=UTF-8",
        "data": data,
        "dataType": "json",
        "success": function (response) {
            var result = response.result;
            if (result === "SUCCESS") {
                layer.msg("删除成功！");
                // 重新加载分页数据
                generatePage();
            }
            if (result === "FAILED") {
                layer.msg("操作失败！" + response.message);
            }
        }, "error": function (response) {
            layer.msg("删除失败！" + response.responseJSON.message);
        }
    });
}


/**
 * 向服务器端获取 pageInfo 数据
 */
function getPageInfoRemote() {
    // 调用$.ajax()函数发送请求并接受$.ajax()函数的返回值
    var ajaxResult = $.ajax({
        "url": url,
        "type": "get",
        "data": {
            "pageNum": pageNum,
            "keyword": keyword
        },
        "async": false,
        "dataType": "json"
    });
    console.log(ajaxResult);
    // 判断当前响应状态码是否为 200
    var statusCode = ajaxResult.status;
    // 如果当前响应状态码不是 200，说明发生了错误或其他意外情况，显示提示消息，让当前函数停止执行
    if (statusCode !== 200) {
        layer.msg(ajaxResult.responseJSON.message);
        return null;
    }
    // 如果响应状态码是 200，说明请求处理成功，获取 pageInfo
    var resultEntity = ajaxResult.responseJSON;
    // 从 resultEntity 中获取 result 属性
    var result = resultEntity.result;
    // 判断 result 是否成功
    if (result === "FAILED") {
        layer.msg(resultEntity.message);
        return null;
    }
    // 确认 result 为成功后获取 pageInfo
    // 返回 pageInfo
    return resultEntity.data;
}


/**
 * 填充列表数据
 */
function fillTableBody(pageInfo) {
    // 把总的复选框清空
    $("#allRoleBox").prop("checked", false);

    var roleBody = $(".rolePageBody");
    roleBody.empty();
    $(".pagination").empty();
    if (pageInfo === null || pageInfo === undefined || pageInfo.list == null || pageInfo.list.length === 0) {
        $("#rolePageBody").append("<tr><td colspan='4' align='center'>抱歉！没有查询到您搜索的数据！</td></tr>");
        return;
    }
    for (const role of pageInfo.list) {
        var td = "<td>" + role.id + "</td>";
        var button = "<button id='showAssignModal' type='button' class='btn btn-success btn-xs'><i class=' glyphicon glyphicon-check'></i></button>\n";
        button = button + "<button id='showUpdateModal' type='button' class='btn btn-primary btn-xs'><i class=' glyphicon glyphicon-pencil'></i></button>\n";
        button = button + "<button id='showDeleteModal' type='button' class='btn btn-danger btn-xs'><i class=' glyphicon glyphicon-remove'></i></button>\n";
        td = td + "<td><input  class='roleBox' type='checkbox'></td>";
        td = td + "<td>" + role.name + "</td>";
        td = td + "<td>" + button + "</td>";
        var tr = "<tr>" + td + "</tr>";
        roleBody.append(tr);
    }
}

/**
 * 绘制分页
 * 传入 PageHelper 的 PageInfo
 */
function js_method(page) {

    //获取 分页 DOM
    var pagination = $(".pagination");

    pagination.text("") //清空导航条

    //首页和上一页
    if (page.pageNum === 1) {
        pagination.append("<li class='disabled'><a href='javascript:void(0);'>首页</a></li>");
        pagination.append("<li class='disabled'><a href='javascript:void(0);'>&laquo;</a></li>");

    } else {
        pagination.append("<li><a href='javascript:void(0);' onclick='pageUp(1)'>首页</a></li>");
        pagination.append("<li><a href='javascript:void(0);' onclick='pageUp(" + page.prePage + ")'>&laquo;</a></li>");
    }

    //中间页码
    for (const p of page.navigatepageNums) {
        if (p === page.pageNum) {
            pagination.append("<li class='active'><a href='javascript:void(0);'>" + p + "<span class='sr-only'>(current)</span></a></li>");
        } else {
            pagination.append("<li><a href='javascript:void(0);' onclick='pageUp(" + p + ")'>" + p + "</a></li>");
        }
    }

    //下一页和末页
    if (page.pageNum === page.pages) {
        pagination.append("<li class='disabled'><a href='javascript:void(0);'>&raquo;</a></li>");
        pagination.append("<li class='disabled'><a href='javascript:void(0);'>末页</a></li>");
    } else {
        pagination.append("<li><a href='javascript:void(0);' onclick='pageUp(" + page.nextPage + ")'>&raquo;</a></li>");
        pagination.append("<li><a href='javascript:void(0);' onclick='pageUp(" + page.pages + ")'>末页</a></li>");
    }
}

/**
 * 渲染权限树结构
 */
function fillAuthTree() {
    // 1.发送 Ajax 请求查询 Auth 数据
    var ajaxReturn = $.ajax({
        "url": authUrl,
        "type": "get",
        "dataType": "json",
        "async": false
    });
    if (ajaxReturn.status !== 200) {
        layer.msg(" 请求处理出错！响应状态码是：" + ajaxReturn.status + " 原因：" + ajaxReturn.statusText);
        return;
    }
    // 2.从响应结果中获取 Auth 的 JSON 数据
    // 从服务器端查询到的 list 不需要组装成树形结构，这里我们交给 zTree 去组装
    var authList = ajaxReturn.responseJSON.data;
    // 3.准备对 zTree 进行设置的 JSON 对象
    var setting = {
        "data": {
            "simpleData": {
                // 开启简单 JSON 功能
                "enable": true, // 使用 categoryId 属性关联父节点，不用默认的 pId 了
                "pIdKey": "categoryId"
            }, "key": {
                // 使用 title 属性显示节点名称，不用默认的 name 作为属性名了
                "name": "title"
            }
        },
        "check": {
            // 显示复选框
            "enable": true
        }
    };
    // 4.生成树形结构
    // <ul id="authTreeDemo" class="ztree"></ul>
    $.fn.zTree.init($("#authTreeDemo"), setting, authList);
    // 获取 zTreeObj 对象
    var zTreeObj = $.fn.zTree.getZTreeObj("authTreeDemo");
    // 调用 zTreeObj 对象的方法，把节点展开
    zTreeObj.expandAll(true);
    // 5.查询已分配的 Auth 的 id 组成的数组
    ajaxReturn = $.ajax({
        "url": assignUrl,
        "type": "get",
        "data": {
            "roleId": roleId
        },
        "dataType": "json",
        "async": false
    });
    if (ajaxReturn.status !== 200) {
        layer.msg(" 请求处理出错！响应状态码是：" + ajaxReturn.status + " 原因：" + ajaxReturn.statusText);
        return;
    }
    // 从响应结果中获取 authIdArray
    var authsId = ajaxReturn.responseJSON.data;
    // 6.根据 authIdArray 把树形结构中对应的节点勾选上
    // ①遍历 authIdArray
    for (const authId of authsId) {
        // ②根据 id 查询树形结构中对应的节点
        var treeNode = zTreeObj.getNodeByParam("id", authId);
        // ③将 treeNode 设置为被勾选
        // checked 设置为 true 表示节点勾选
        var checked = true;
        // checkTypeFlag 设置为 false，表示不“联动”，不联动是为了避免把不该勾选的勾选上
        var checkTypeFlag = false;
        // 执行
        zTreeObj.checkNode(treeNode, checked, checkTypeFlag);
    }
}

function saveAssign() {
    // ①收集树形结构的各个节点中被勾选的节点
    // [1]声明一个专门的数组存放 id
    var authIdArray = [];
    // [2]获取 zTreeObj 对象
    var zTreeObj = $.fn.zTree.getZTreeObj("authTreeDemo");
    // [3]获取全部被勾选的节点
    var checkedNodes = zTreeObj.getCheckedNodes();

    // [4]遍历 checkedNodes
    for (const checkedNode of checkedNodes) {
        var authId = checkedNode.id;
        authIdArray.push(authId);
    }
    // ②发送请求执行分配
    var requestBody = {
        "authIdArray": authIdArray, // 为了服务器端 handler 方法能够统一使用 List<Integer>方式接收数据，roleId 也存入数组
        "roleId": [roleId]
    };
    requestBody = JSON.stringify(requestBody);
    $.ajax({
        "url": assignUrl,
        "type": "post",
        "data": requestBody,
        "contentType": "application/json;charset=UTF-8",
        "dataType": "json",
        "success": function (response) {
            var result = response.result;
            if (result === "SUCCESS") {
                layer.msg("操作成功！");
            }
            if (result === "FAILED") {
                layer.msg("操作失败！" + response.message);
            }
        }, "error": function (response) {
            layer.msg(response.status + "错误" + response.statusText);
        }
    });
    $("#assign-role").modal("hide");
}

/**
 * 点击翻页
 * @param num
 */
var pageUp = function (num) {
    pageNum = num;
    generatePage();
}