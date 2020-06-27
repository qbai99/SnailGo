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
function charge() {
   var chargeInput =  $('#chargeInput').val();
   if(parseFloat(chargeInput)<=0){
       alert("充值金额不能为负数！");
       $('#chargeInput').val("0");
       return;
   }
   else {
       $.ajax({
           type: "POST",
           url: "/balance/postcharge",
           data: {
               // userAdmin:userEmail,
               input: chargeInput
           },
           success: function (res) {
               alert("充值成功！");
               $('#balance').html(res.balance);

           }
       })
   }

}