// var userEmail = document.cookie.split('=')[6];
// console.log(userEmail);
var binaryFile;

function check(){
    console.log($('#exampleInputFile').val());
    var reads = new FileReader();
    console.log(document.getElementById('exampleInputFile').files);
    var f = document.getElementById('exampleInputFile').files[0];
    reads.readAsDataURL(f);
    reads.onload = function (e) {
        binaryFile = this.result;
        console.log("上传图片"+this.result);
        $('#preview').attr('src',this.result);
        console.log(f);
    }

}

function IfExist(){
    var email = $('#emailInput').val();
    $.ajax({
        type:"POST",
        url:"/user/emailExist",
        data:{
            newEmail:email
        },
        success:function (res) {
            if(res.toString()=='false') {
                alert("该邮箱已存在！");
                window.location.reload();
            }
        }
    })

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
        $('#sideImg').attr('src',res.UserInfo[0].userImg);

        $("#emailInput").attr('value',res.UserInfo[0].userAdmin);
        // $("#passwordInput").attr('value',res.UserInfo[0].userPassword);
        $("#userName").attr('value',res.UserInfo[0].userName);
        $("#sideName").html(res.UserInfo[0].userName);
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
                $("#identity").html("卖家");
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
            // email:userEmail,
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
            window.location.reload();
        }
    })
}
