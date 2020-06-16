$.ajax({
    type:"GET",
    url:"/order/check",
    success:function (res) {

        console.log(res);
        for(var i = 0; i < res.Order.length;i++) {
            var bigDiv = $('<div class="card-header">' +
                '<div class="row">' +
                '<label>订单号：' + res.ShippingState[i].id + '<br>' +
                '商品名：' + res.Order[i].goodsName + '<br>' +
                '单价：' + res.Order[i].goodsPrice + '元' + '<br>' +
                '数量：' + res.Order[i].goodsQuantity + '<br>' +
                '总额：' + (parseFloat(res.Order[i].goodsQuantity) * parseFloat(res.Order[i].goodsPrice)) + '元' + '<br>' +
                '买家id：' + res.Buyer[i].userId + '<br>' +
                '买家名：' + res.Buyer[i].userName + '<br>' +
                '卖家id：' + res.Seller[i].userId + '<br>' +
                '卖家名：' + res.Seller[i].userName + '<br>' +
                '货物当前地点：' + res.ShippingState[i].loc + '<br>' +
                '配送状态：' + res.ShippingState[i].otherInfo + '</label>' +
                '</div>' +
                '</div>');
            $('#address').append(bigDiv);
        }
    }
})