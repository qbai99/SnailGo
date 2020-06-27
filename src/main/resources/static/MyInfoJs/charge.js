$.ajax({
    type: "GET",
    url: "/user/information",
    success: function (res, ifo) {
        $('#sideImg').attr('src', res.UserInfo[0].userImg);
        $("#sideName").html(res.UserInfo[0].userName);
    }
});
$.ajax({
    type:"GET",
    url:"/balance/check",
    // data:{
    //     userAdmin:userEmail
    // },
    success:function (res) {
        $('#balance').html(res[0].balance);
    }
})
