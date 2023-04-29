var data = {
    "result": "SUCCESS",
    "message": null,
    "data": {
        "total": 233,
        "list": [{"id": 36, "name": "Role35"}, {"id": 37, "name": "Role36"}, {"id": 38, "name": "Role37"}, {
            "id": 39,
            "name": "Role38"
        }, {"id": 40, "name": "Role39"}],
        "pageNum": 8,
        "pageSize": 5,
        "size": 5,
        "startRow": 36,
        "endRow": 40,
        "pages": 47,
        "prePage": 7,
        "nextPage": 9,
        "isFirstPage": false,
        "isLastPage": false,
        "hasPreviousPage": true,
        "hasNextPage": true,
        "navigatePages": 5,
        "navigatepageNums": [6, 7, 8, 9, 10],
        "navigateFirstPage": 6,
        "navigateLastPage": 10
    }
}
var url = "https://www.baidu.com";
$(function () {

    var pageInfo = data.data;

    js_method(pageInfo);
});

/**
 * 传入 PageHelper 的 PageInfo
 */
function js_method(page) {

    var pagination = $(".pagination");

    pagination.text("") //清空导航条

    if (page.pageNum === 1) {
        pagination.append("<li class='disabled'><a href='"+ url + "1'>首页</a></li>");
        pagination.append("<li class='active'><a href='"+ url + page.prePage + "'>&laquo;</a></li>");

    } else {
        pagination.append("<li><a href='"+ url + "1'>首页</a></li>");
        pagination.append("<li><a href='"+ url + page.prePage + "'>&laquo;</a></li>");
    }

    for (const p of page.navigatepageNums) {
        if (p === page.pageNum) {
            pagination.append("<li class='active'><a href='"+ url + p + "'>" + p + "<span class='sr-only'>(current)</span></a></li>");
        } else {
            pagination.append("<li><a href='"+ url + p + "'>" + p + "</a></li>");
        }
    }

    if (page.pageNum === page.pages) {
        pagination.append("<li class='active'><a href='"+ url + page.nextPage + "'>&raquo;</a></li>");
        pagination.append("<li class='disabled'><a href='"+ url + page.pages + "'>末页</a></li>");
    } else {
        pagination.append("<li><a href='"+ url + page.nextPage + "'>&raquo;</a></li>");
        pagination.append("<li><a href='"+ url + page.pages + "'>末页</a></li>");
    }
}