$.ajax({
    type:"GET",
    url:"/balance/check",
    success:function (res) {
        $('#balance').html(res[0].balance);
    }
})
function charge() {
   var chargeInput =  $('#chargeInput').val();
   if(parseFloat(chargeInput)<=0){
       alert("充值金额不能为负数！");
       return;
   }
   else {
       $.ajax({
           type: "POST",
           url: "/balance/postcharge",
           data: {
               input: chargeInput
           },
           success: function (res) {
               alert("充值成功！");
               $('#balance').html(res.balance);
           }
       })
   }

}