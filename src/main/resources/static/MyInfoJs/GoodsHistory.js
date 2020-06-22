var his = window.location.href;
console.log(his);
var goodsId = his.split("=")[1];
console.log(goodsId);
var userEmail = document.cookie.split('=')[6];
$.ajax({
    type:"POST",
    url:"/Records/addrecords",
    data:{
        userAdmin:userEmail,
        URL:his,
        goodsId:goodsId
    },
    success:function (res) {

    }
})