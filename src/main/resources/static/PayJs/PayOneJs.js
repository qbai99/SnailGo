$.ajax({
    type:"POST",
    url:"/payonejs",
    contentType:"application/json; charset=utf-8",
    dataType:"json",
    async:false,
    success:function (res,ifo) {
        console.log(res);
        /*console.log(res[0].goodsId);
        console.log(res.goodsId);*/
        var price= res[0].goodsPrice/res[0].goodsQuantity;
        var bigDiv = $('<tr>'+
            '<td><a href='+"goods/details?id="+res[0].goodsId+'>'+
            '<img style="width: 4vh;height: 4vh" src='+"/goods_pics/"+res[0].goodsId+"-pic-1.jpg"+' class="product-image" alt="Product Image">'+
            res[0].goodsName+
            '</a></td>'+
            '<td></td>'+
            '<td>'+price+'</td>'+
            '<td>'+res[0].goodsQuantity+'</td>'+
            '<td>'+res[0].goodsPrice+'</td>'+
            '</tr>'
        );
        $('#paytable').append(bigDiv);
        var totalDiv = $('<tr>'+
            '<th>总计:</th>'+
            '<td id="total">'+res[0].goodsPrice+'</td>'+
            '</tr>'
        );
        $('#totaltable').append(totalDiv);
        var str='';
        str +='/balancePay?total=';
        str += res[0].goodsPrice;
        $('#paya').attr("href",str);
    }
})
