$(document).ready(function () {
    bsCustomFileInput.init();

    if($.cookie("username")==null){

    };
});
function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) c_end = document.cookie.length;
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}
a=getCookie("username");
c_start=document.cookie.indexOf("username=");
console.log(c_start)

if(c_start == -1){
    $("#login").append('<a href="/loginPage" target="_parent">登录/注册</a>');
}
else{
    $("#login").hide();

}
$.ajax({
    type: "GET",
    url: "/user/information",
    contentType: "application/json; charset=utf-8",
    // dataType: "json",
    success: function (res, ifo) {
    $("#test").append(res.UserInfo[0].userName);
    },
    fali:function () {
        console.log("错误")
    },
    error:function () {
        console.log("报错")
    }
});


