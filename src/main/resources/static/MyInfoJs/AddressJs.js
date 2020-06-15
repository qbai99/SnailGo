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
                '<label>'+res[i].address+'</label>' +
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
    var newAddress = $('#newAddress').val();
    $.ajax({
        type:"POST",
        url:"/address/addaddress",
        data:{
            newAddress:newAddress
        },
        success:function (res) {
            index+=1;
            alert("添加成功！");
            var bigDiv = $('<div class="card-header">' +
                '<div class="row">' +
                '<label>'+newAddress+'</label>' +'<button id="button' + index +
                '" class="btn btn-info" style="position: absolute;' +
                'right: 2%;">删除</button>'+
                '</div>' +
                '</div>');
            $('#address').append(bigDiv);
            addressID.push(res[0].addressId);

        }
    })
}
console.log(addressID);
function deleteHandle(event) {
    console.log(event.target);

}