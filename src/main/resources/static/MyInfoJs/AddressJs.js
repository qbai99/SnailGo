var phoneNumber;
$.ajax({
    type: "GET",
    url: "/user/information",
    success: function (res, ifo) {
        $('#sideImg').attr('src', res.UserInfo[0].userImg);
        $("#sideName").html(res.UserInfo[0].userName);
    }
});
$.ajax({
    type:"POST",
    url:"/address/myaddress",
    // data:{
    //     userAdmin:userEmail
    // },
    success:function (res) {
        console.log(res);
        for(var i = 0;i<res.length;i++){
            var bigDiv = $('<tr>' +
                '<td>'+res[i].address.split("/")[0]+res[i].address.split("/")[1]+res[i].address.split("/")[2]+
                res[i].address.split("/")[3]+
                '</td>'+
                '<td>'+
                res[i].address.split("/")[5]+
                '</td>'+
                '<td>'+
                res[i].address.split("/")[4]+
                '</td>'+
                '<td class="project-actions text-right" >'+
                '<a class="btn btn-danger btn-sm" href='+"/address/deleteaddress?addressId="+res[i].addressId+'>'+
                '<i class="fas fa-trash">'+
                '</i>'+
                '删除'+
                '</a>'+
                '</td>'+
                '</tr>');
            $('#addressTable').append(bigDiv);
        }
    }
})


function checkInput() {
    phoneNumber = $('#newPhoneNumber').val();
    console.log(phoneNumber.length);
    if(phoneNumber.length!=11 && phoneNumber.length!=7){
        $('#alert').html("手机号码的长度应该为7或11！");
        console.log(1)
    }
    else{
        $('#alert').html("");
        console.log(3)
    }
}
function AddAddress() {
    var province = $('#province').val();
    console.log(province);
    var city = $('#city').val();
    var street = $('#street').val();
    var Address = $('#newAddress').val();
    var phoneNumber = $('#newPhoneNumber').val();
    var people = $('#newPeople').val();
    var newAddress = province+"/"+city+"/"+street+"/"+Address+"/"+phoneNumber+"/"+people;
    if(phoneNumber.length!=11 && phoneNumber.length!=7)
    {
        alert("手机号码的长度应该为7或11！");
        return;
    }
    else{
        $.ajax({
            type:"POST",
            url:"/address/addaddress",
            data:{
                newAddress:newAddress,
                // userAdmin:userEmail
            },
            success:function (res) {
                alert("添加成功！");
                window.location.reload();
            }
        })
    }

}