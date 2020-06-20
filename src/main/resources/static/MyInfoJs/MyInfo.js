var userEmail = document.cookie.split('=')[6];
console.log(userEmail);
$.ajax({
    type: "GET",
    url: "/user/information",
    // data:JSON.stringify(dataObj) ,
    data:{
        userEmail:userEmail
    },
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (res, ifo) {
        $("#emailInput").attr('value',res.UserInfo[0].userAdmin);
        // $("#passwordInput").attr('value',res.UserInfo[0].userPassword);
        $("#userName").attr('value',res.UserInfo[0].userName);
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
    }
});

function clickHandle() {
    var email = $('#emailInput').val();
    var username = $('#userName').val();
    var sex = $('#sex').val();
    var birthdate = $('#birthDate').val();
    var phonenumber = $('#phoneNumber').val();
    var introduction = $('#introduction').val();
    var realsex;
    switch (sex) {
        case "保密":
            realsex=0;
            break;
        case "男":
            realsex=1;
            break;
        case "女":
            realsex=2;
            break;
        default:
            break;
    }
    $.ajax({
        type:'POST',
        url:'/user/updateInfo',
        data:{
            email:userEmail,
            newAdmin:email,
            username:username,
            sex:realsex,
            birthdate:birthdate,
            phonenumber:phonenumber,
            introduction:introduction,
            file:binaryFile
        },
        success:function (res) {

            $("#emailInput").attr('value',res.userAdmin);
            // $("#passwordInput").attr('value',res.UserInfo[0].userPassword);
            $("#userName").attr('value',res.userName);
            console.log(Number(res.usersex))
            switch (Number(res.usersex)) {
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
            $("#birthDate").attr('value',res.userBirthdate);
            $("#phoneNumber").attr('value',res.userPhonenumber);
            $("#introduction").attr('value',res.userIntroductoin);
            alert("保存成功！");
        }
    })
}
