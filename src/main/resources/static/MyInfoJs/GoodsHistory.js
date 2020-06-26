var his = window.location.href;
console.log(his);
var goodsId = his.split("=")[1];
console.log(goodsId);
$.ajax({
    type: "GET",
    url: "/user/information",
    success: function (res, ifo) {
        $('#sideImg').attr('src', res.UserInfo[0].userImg);
        $("#sideName").attr('value', res.UserInfo[0].userName);
    }
});
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
