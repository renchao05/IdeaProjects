// 用于存储对 zTree 所做的设置
var setting = {
    view: {
        // 修改图标样式
        addDiyDom: addDiyDom,
        // 鼠标移入 添加按钮
        addHoverDom: addHoverDom,
        // 鼠标移除 删除按钮
        removeHoverDom: removeHoverDom
    },
    data: {
        key: {
            // 实现点击不跳转
            url: "xUrl"
        }
    }
};

function init() {
    var treeDemo = $("#treeDemo");

    // 显示 添加 模态框
    treeDemo.on("click", ".addBtn", function () {
        pid = this.id;
        $("#menu-add").modal("show");
    });

    // 显示 修改 模态框
    treeDemo.on("click", ".updateBtn", function () {
        // 获取当前节点id
        id = this.id;
        // 获取 zTreeObj 对象
        var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
        // 根据 id 属性查询节点对象
        var currentNode = zTreeObj.getNodeByParam("id", id);
        // 回显表单数据
        $("#menu-update [name=name]").val(currentNode.name);
        $("#menu-update [name=url]").val(currentNode.url);
        $("#menu-update [name=icon]").val([currentNode.icon]);
        //显示模态框
        $("#menu-update").modal("show");
    });

    // 显示 删除 模态框
    treeDemo.on("click", ".deleteBtn", function () {
        // 获取要删除的对象 id ，存入全局变量
        id = this.id;
        $("#removeNodeSpan").text($(this).parent().prev("a").attr("title"));
        $("#menu-delete").modal("show");
    });


    // 准备保存
    $("#menuSaveBtn").click(function () {
        var data = {
            pid: pid,
            name: $("#menu-add input[name=name]").val(),
            url: $("#menu-add input[name=url]").val(),
            icon: $("#menu-add input[name=icon]:checked").val()
        };
        if (data.name === "" || data.url === "" || data.icon === undefined) {
            layer.msg("请填写完整！")
            return;
        }
        // 发送 JSON 到服务器，必须要序列化为字符串
        var dataStr = JSON.stringify(data);
        // 发送 Ajax 保存，保存是POST请求，使用默认
        menuAjax(dataStr);
        // 关闭模态框
        $("#menu-add").modal("hide");
        // 重置模态框
        $("#menuResetBtn").click();
    });

    // 准备修改
    $("#menuEditBtn").click(function () {
        var data = {
            id: id,
            name: $("#menu-update input[name=name]").val(),
            url: $("#menu-update input[name=url]").val(),
            icon: $("#menu-update input[name=icon]:checked").val()
        };
        if (data.name === "" || data.url === "" || data.icon === undefined) {
            layer.msg("请正确填写！")
            return;
        }
        // 发送 JSON 到服务器，必须要序列化为字符串
        var dataStr = JSON.stringify(data);

        // 发送 Ajax 保存，保存是PUT请求
        menuAjax(dataStr, "PUT");

        // 关闭模态框
        $("#menu-update").modal("hide");
    });

    // 准备删除
    $("#confirmBtn").click(function () {
        var data = {
            id: id
        };
        // 发送 JSON 到服务器，必须要序列化为字符串
        var dataStr = JSON.stringify(data);

        // 发送 Ajax 保存，保存是PUT请求
        menuAjax(dataStr, "DELETE");

        // 关闭模态框
        $("#menu-delete").modal("hide");
    });
}

/**
 * 设置图标
 */
function addDiyDom(treeId, treeNode) {
    // 先移除样式，然后再添加正确的样式
    console.log(treeNode);
    $("#" + treeNode.tId + "_ico").removeClass().addClass(treeNode.icon);
}


// 在鼠标移入节点范围时添加按钮组
function addHoverDom(treeId, treeNode) {
    // 按钮组的标签结构：<span><a><i></i></a><a><i></i></a></span>
    // 按钮组出现的位置：节点中 treeDemo_n_a 超链接的后面
    // 为了在需要移除按钮组的时候能够精确定位到按钮组所在 span，需要给 span 设置有规律的 id
    var btnGroupId = treeNode.tId + "_btnGrp";
    // 判断一下以前是否已经添加了按钮组
    if ($("#" + btnGroupId).length > 0) {
        return;
    }
    // 准备各个按钮的 HTML 标签
    var addBtn = "<a id='" + treeNode.id + "' class='addBtn btn btn-info dropdown-toggle btn-xs' " +
        "style='margin-left:10px;padding-top:0;' title='添加子节点'>&nbsp;&nbsp;" +
        "<i class='fa fa-fw fa-plus rbg '></i></a>";

    var removeBtn = "<a id='" + treeNode.id + "' class='deleteBtn btn btn-info dropdown-toggle btn-xs' " +
        "style='margin-left:10px;padding-top:0;' title='删除节点'>&nbsp;&nbsp;" +
        "<i class='fa fa-fw fa-times rbg '></i></a>";

    var editBtn = "<a id='" + treeNode.id + "' class='updateBtn btn btn-info dropdown-toggle btn-xs' " +
        "style='margin-left:10px;padding-top:0;' title='修改节点'>&nbsp;&nbsp;" +
        "<i class='fa fa-fw fa-edit rbg '></i></a>";
    // 获取当前节点的级别数据
    var level = treeNode.level;
    // 声明变量存储拼装好的按钮代码
    var btnHTML = "";
    // 判断当前节点的级别
    if (level === 0) {
        // 级别为 0 时是根节点，只能添加子节点
        btnHTML = addBtn;
    }
    if (level === 1) {
        // 级别为 1 时是分支节点，可以添加子节点、修改
        btnHTML = addBtn + editBtn;
        // 获取当前节点的子节点数量
        var length = treeNode.children.length;
        // 如果没有子节点，可以删除
        if (length === 0) {
            btnHTML = btnHTML + removeBtn;
        }
    }
    if (level === 2) {
        // 级别为 2 时是叶子节点，可以修改、删除
        btnHTML = editBtn + removeBtn;
    }
    // 找到附着按钮组的超链接
    var anchorId = treeNode.tId + "_a";
    // 执行在超链接后面附加 span 元素的操作
    $("#" + anchorId).after("<span id='" + btnGroupId + "'>" + btnHTML + "</span>");
}

// 鼠标移除节点范围时删除按钮组
function removeHoverDom(treeId, treeNode) {
    var btnGroupId = treeNode.tId + "_btnGrp";
    $("#" + btnGroupId).remove();
}


/**
 * 增删改查 Ajax
 */

function menuAjax(data, method) {
    var ajaxUrl;
    var type = "post";
    // get 和 post 不需要 _method 参数，使用的时候，不传 method
    if (method) {
        ajaxUrl = url + "?_method=" + method;
    } else {
        ajaxUrl = url;
    }
    // 查询的时候，两个参数都不传，请求方式改为 get
    if (!data) {
        type = "get";
        data = "";
    }

    $.ajax({
        "url": ajaxUrl,
        "type": type,
        "data": data,
        "dataType": "json",
        "contentType": "application/json;charset=UTF-8",
        "success": function (response) {
            var result = response.result;
            if (result === "SUCCESS") {
                if (data) {
                    layer.msg("操作成功！");
                }
                var zNodes = response.data;
                // 通过 zTree 生成菜单
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            }
            if (result === "FAILED") {
                layer.msg("操作失败！" + response.message);
            }
        }, "error": function (response) {
            layer.msg(response.status + " " + response.statusText);
        }
    });
}