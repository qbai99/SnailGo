var oldPassword = '';
var rewriteoldPassword = '';
var newPassword = '';
var userEmail = document.cookie.split('=')[6];
console.log(userEmail);

function Oldlistener() {
    oldPassword = $("#oldpassword").val();
}

function RewriteOldlistener() {
    rewriteoldPassword = $("#rewriteoldpassword").val();
    if(oldPassword==newPassword || rewriteoldPassword==oldPassword){
        $("#alertRewrite").html("新密码不能和旧密码相同！");
    }
    else{
        $("#alertRewrite").html("");
    }
}

function Newlistener() {
    newPassword = $("#newpassword").val();
    if(newPassword.length>=15){
        $("#alertNew").html("密码的长度不能超过15");
    }
    if(newPassword.length<=15){
        $("#alertNew").html("");
    }
    var hasSimple = false;
    for(var i = 0;i<newPassword.length;i++){
        if(newPassword.charCodeAt(i)>255){
            hasSimple=true;
            break;
        }
    }
    if(hasSimple==true){
        $("#alertNew").html("密码中只能含有英文字符、数字和特殊符号");
    }
    if(oldPassword==newPassword || rewriteoldPassword==oldPassword){
        $("#alertNew").html("新密码不能和旧密码相同！");
    }
    if(newPassword!=rewriteoldPassword){
        $("#alertNew").html("两次输入的密码不一致！");
    }
    else{
        $("#alertNew").html("");
    }
}
function submitChange() {
    if(newPassword!=rewriteoldPassword){
        alert("两次输入的密码不一致！");
        return;
    }
    newPassword = $("#newpassword").val();
    if(newPassword.length>=15){
        alert("密码的长度不能超过15");
        return;
    }
    if(newPassword.length<=15){
        $("#alertNew").html("");
    }
    var hasSimple = false;
    for(var i = 0;i<newPassword.length;i++){
        if(newPassword.charCodeAt(i)>255){
            hasSimple=true;
            break;
        }
    }
    if(hasSimple==true){
        alert("密码中只能含有英文字符、数字和特殊符号");
        return;
    }
    if(oldPassword==newPassword || rewriteoldPassword==oldPassword){
        alert("新密码不能和旧密码相同！");
        return;
    }
    else {
        $.ajax({
            type: "POST",
            url: "/user/changeCommit",
            async: true,
            data: {
                "oldPassword": oldPassword,
                "newPassword": newPassword,
                userAdmin:userEmail
            },
            success: function (res) {
                alert(res);
            },
        })
    }
}