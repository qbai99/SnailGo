$.ajax({
    type:"GET",
    url:"/order/check",
    success:function (res) {

        console.log(res);
        for(var i = 0; i < res.Order.length;i++) {
            var bigDiv = $('<div class="card-header">' +
                '<div class="row">' +
                '<div class="col-md-6">' +
                '<div class="form-group">' +
                '<label class="card-header">订单号：' + res.ShippingState[i].id + '<br></label>' +
                '<p class="form-control"><label>商品名：</label>' + res.Order[i].goodsName + '</p>' +
                '<p class="form-control"><label>单价：</label>' + res.Order[i].goodsPrice + '元' + '</p>' +
                '<p class="form-control"><label>数量：</label>' + res.Order[i].goodsQuantity + '</p>' +
                '<p class="form-control"><label>总额：</label>' + (parseFloat(res.Order[i].goodsQuantity) * parseFloat(res.Order[i].goodsPrice)) + '元' + '<br>' +'</p>'+
                '</div></div>' +
                '<div class="col-md-6">' +
                // '买家id：' + res.Buyer[i].userId + '<br>' +
                '<div class="form-group">' +
                '<label class="card-header"><br></label>' +
                '<p class="form-control"><label>买家名：</label>' + res.Buyer[i].userName + '</p>' +
                // '卖家id：' + res.Seller[i].userId + '<br>' +
                '<p class="form-control"><label>卖家名：</label>' + res.Seller[i].userName + '<br>' +'</p>'+
                '<p class="form-control"><label>货物当前地点：</label>' + res.ShippingState[i].loc + '</p>' +
                '<p class="form-control"><label>配送状态：</label>' + res.ShippingState[i].otherInfo + '</p>' +
                '</div></div>' +
                '</div>' +
                '</div>');
            $('#address').append(bigDiv);
        }
    }
})