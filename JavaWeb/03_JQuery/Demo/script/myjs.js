$(function () {
    var obj = {
        i: 8,
        k: 9,
        c: {x: 9,y: 99}
    }

    var $btnObj = $("#btnId");
    $btnObj.click(function () {
        vue.message = obj;
        alert(vue.message.c.x);
    });

    var vue = new Vue({
        el: "#app",
        data: {
            message: "hello,任超==",
            vueValue: "任超，你好！！",
            json: {}
        }
    });
});