
$.ajax({
    type:"GET",
    url:"/order/check",
    // data:{
    //     userAdmin:userEmail
    // },
    success:function (res) {

        console.log(res);
        for(var i = 0; i < res.Order.length;i++) {
            var bigDiv = $('<tr>' +
                '<td>'+
                res.Order[i].orderId+
                '</td>'+
                '<td>'+
                '<a href='+"/goods/details?id="+res.Order[i].goodsId+'>'+
                '<img style="width:4vh;height: 4vh" src='+"/goods_pics/"+res.Order[i].goodsId+"-pic-1.jpg"+' class="product-image" alt="Product Image">'+
                ''+res.Order[i].goodsName+''+
                '</a>'+
                '</td>'+
                '<td>'
                + res.Order[i].goodsPrice + '元' +
                '</td>'+
                '<td>'
                + res.Order[i].goodsQuantity+
                '</td>'+
                '<td>'+
                (parseFloat(res.Order[i].goodsQuantity) * parseFloat(res.Order[i].goodsPrice)) + '元'+
                '</td>'+
                '<td>'+
                res.Buyer[i].userName+
                '</td>'+
                '<td>'+
                res.Seller[i].userName+
                '</td>'+
                '<td>'+
                res.ShippingState[i].loc+
                '</td>'+
                '<td>'+
                res.ShippingState[i].otherInfo+
                '</td>'+
                // '<td class="project-actions text-right" >'+
                // '<a class="btn btn-danger btn-sm" href='+"/Records/deleterecords?recordsId="+res.BrowsingRecords[i].recordsId+'>'+
                // '<i class="fas fa-trash">'+
                // '</i>'+
                // '删除'+
                // '</a>'+
                // '</td>'+
                '</tr>');

            $('#orderTable').append(bigDiv);
        }
    }
})