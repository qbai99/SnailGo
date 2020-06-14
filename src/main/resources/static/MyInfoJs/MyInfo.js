$.ajax({
    type: "POST",
    url: "/user/information",
    // data:JSON.stringify(dataObj) ,
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (res, ifo) {
        $("#emailInput").attr('value',res[0].userAdmin);
        $("#passwordInput").attr('value',res[0].userPassword);
        $("#userName").attr('value',res[0].userName);
        switch (res[0].usersex) {
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
        $("#birthDate").attr('value',res[0].userBirthdate);
        $("#phoneNumber").attr('value',res[0].userPhonenumber);
        $("#introduction").attr('value',res[0].userIntroduction);
        console.log(res[0]);
    }
});
