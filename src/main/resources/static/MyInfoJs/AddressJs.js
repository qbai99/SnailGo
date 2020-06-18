var addressID = new Array();//存地址
var index = -1;
$.ajax({
    type:"POST",
    url:"/address/myaddress",
    success:function (res) {
        console.log(res);
        for(var i = 0;i<res.length;i++){
            var bigDiv = $('<div class="card-header">' +
                '<div class="row">' +
                '<label>id:'+res[i].addressId+"/"+res[i].address+'</label>' +
                '<button id="button' + i +
                '" class="btn btn-info" style="position: absolute;' +
                'right: 2%;"onclick="deleteHandle()">删除</button>' +
                '</div>' +
                '</div>');
            $('#address').append(bigDiv);
            addressID.push(res[i].addressId);
        }
        index = res.length-1;
    }
})

function AddAddress() {
    var Address = $('#newAddress').val();
    var phoneNumber = $('#newPhoneNumber').val();
    var people = $('#newPeople').val();
    var newAddress = Address+"/"+phoneNumber+"/"+people;
    $.ajax({
        type:"POST",
        url:"/address/addaddress",
        data:{
            newAddress:newAddress,
        },
        success:function (res) {
            index+=1;
            alert("添加成功！");
            addressID.push(res[0].addressId);
            window.location.reload();
            // var bigDiv = $('<div class="card-header">' +
            //     '<div class="row">' +
            //     '<label class="address">'+newAddress+'</label>' +'<button id="button' + index +
            //     '" class="btn btn-info" style="position: absolute;' +
            //     'right: 2%;" onclick="deleteHandle(this)">删除</button>'+
            //     '</div>' +
            //     '</div>');
            // $('#address').append(bigDiv);


        }
    })
}
console.log(addressID);

function DeleteAddress() {
    var addressId = $('#deleteInput').val();
    $.ajax({
        type:'POST',
        url:'/address/deleteaddress',
        data:{
            addressId:addressId
        },
        success:function (res) {
            console.log(res);
            alert("删除成功！");
            window.location.reload();
        }
    })
}