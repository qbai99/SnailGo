$.ajax({
    type:"GET",
    url:"/balance/check",
    success:function (res) {
        $('#balance').html(res[0].balance);
    }
})
function charge() {
   var chargeInput =  $('#chargeInput').val();
   $.ajax({
       type:"POST",
       url:"/balance/postcharge",
       data:{
           input:chargeInput
       },
       success:function (res) {
           alert("充值成功！");
           $('#balance').html(res.balance);
       }
   })

}