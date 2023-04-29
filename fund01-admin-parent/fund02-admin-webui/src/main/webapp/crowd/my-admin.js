/**
 * 传入 PageHelper 的 PageInfo
 */
function js_method(page) {

    //获取 分页 DOM
    var pagination = $(".pagination");

    pagination.text("") //清空导航条

    //首页和上一页
    if (page.pageNum === 1) {
        pagination.append("<li class='disabled'><a href='javascript:void(0);'>首页</a></li>");
        pagination.append("<li class='active'><a href='javascript:void(0);'>&laquo;</a></li>");

    } else {
        pagination.append("<li><a href='javascript:void(0);' onclick='pageUp(1)'>首页</a></li>");
        pagination.append("<li><a href='javascript:void(0);' onclick='pageUp("+ page.prePage +")'>&laquo;</a></li>");
    }

    //中间页码
    for (const p of page.navigatepageNums) {
        if (p === page.pageNum) {
            pagination.append("<li class='active'><a href='javascript:void(0);'>" + p + "<span class='sr-only'>(current)</span></a></li>");
        } else {
            pagination.append("<li><a href='javascript:void(0);' onclick='pageUp("+ p +")'>" + p + "</a></li>");
        }
    }

    //下一页和末页
    if (page.pageNum === page.pages) {
        pagination.append("<li class='active'><a href='javascript:void(0);'>&raquo;</a></li>");
        pagination.append("<li class='disabled'><a href='javascript:void(0);'>末页</a></li>");
    } else {
        pagination.append("<li><a href='javascript:void(0);' onclick='pageUp("+ page.nextPage +")'>&raquo;</a></li>");
        pagination.append("<li><a href='javascript:void(0);' onclick='pageUp("+ page.pages +")'>末页</a></li>");
    }
}