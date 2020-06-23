var his = window.location.href;
console.log(his);
var goodsId = his.split("=")[1];
console.log(goodsId);
$.ajax({
    type:"POST",
    url:"/Records/addrecords",
    data:{
        URL:his,
        goodsId:goodsId
    },
    success:function (res) {
        console.log(res);
    }
})