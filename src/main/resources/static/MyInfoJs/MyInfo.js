$.ajax({
    type: "GET",
    url: "/user/information",
    // data:JSON.stringify(dataObj) ,
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (res, ifo) {
        $("#emailInput").attr('value',res.UserInfo[0].userAdmin);
        $("#passwordInput").attr('value',res.UserInfo[0].userPassword);
        $("#userName").attr('value',res.UserInfo[0].userName);
        switch (res.UserInfo[0].usersex) {
            case 0:
                $("#sex").attr('value','保密');
                break;
            case 1:
                $("#sex").attr('value','男');
                break;
            case 2:
                $("#sex").attr('value','女');
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
    }
});


