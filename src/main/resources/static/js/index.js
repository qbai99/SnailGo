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
    $("#login").append('<a href="/loginPage" target="_blank">登录/注册</a>');
}
else{
    $("#login").hide();
}


$.ajax({
    type: "GET",
    url: "/user/information",
    // data:JSON.stringify(dataObj) ,
    // data:{
    //     userEmail:userEmail
    // },
    contentType: "application/json; charset=utf-8",
    // dataType: "json",
    success: function (res, ifo) {
        binaryFile = res.UserInfo[0].userImg;
        console.log("返回图片"+res.UserInfo[0].userImg);
        $('#preview').attr('src',res.UserInfo[0].userImg);
        $("#emailInput").attr('value',res.UserInfo[0].userAdmin);
        // $("#passwordInput").attr('value',res.UserInfo[0].userPassword);
        $("#userNameindex").attr('value',res.UserInfo[0].userName);
        $("#test").html(res.UserInfo[0].userName);
        console.log(Number(res.UserInfo[0].usersex))
        switch (Number(res.UserInfo[0].usersex)) {
            case 0:
                $("#sex").val('保密');
                break;
            case 1:
                $("#sex").val('男');
                break;
            case 2:
                $("#sex").val('女');
                break;
            default:
                break;
        }
        $("#birthDate").attr('value',res.UserInfo[0].userBirthdate);
        $("#phoneNumber").attr('value',res.UserInfo[0].userPhonenumber);
        $("#introduction").attr('value',res.UserInfo[0].userIntroduction);

        $("#balance").html(res.UserFinance[0].balance);
        $("#level").html(res.UserLevel[0].level);
        $("#point").html(res.UserLevel[0].points);
        switch (res.UserInfo[0].userTag) {
            case false:
                $("#identity").html("买家");
                break;
            case true:
                $("#identity").html("买家");
                break;
            default:
                break;
        }
        console.log(res);
    },
    fali:function () {
        console.log("错误")
    },
    error:function () {
        console.log("报错")
    }
});