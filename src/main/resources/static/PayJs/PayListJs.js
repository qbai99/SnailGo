$.ajax({
    type:"POST",
    url:"/paylistjs",
    contentType:"application/json; charset=utf-8",
    dataType:"json",
    async:false,
    success:function (res,ifo) {
        console.log(res);
        var totalnum=0;
        for(var i=0;i<res.length;i++){
            var price = res[i].goodsPrice/res[i].goodsQuantity;
            var bigDiv = $('<tr>'+
                '<td><a href='+"goods/details?id="+res[i].goodsId+'>'+
                '<img style="width: 4vh;height: 4vh" src='+"/goods_pics/"+res[i].goodsId+"-pic-1.jpg"+' class="product-image" alt="Product Image">'+
                res[i].goodsName+
                '</a></td>'+
                '<td></td>'+
                '<td>'+price+'</td>'+
                '<td>'+res[i].goodsQuantity+'</td>'+
                '<td>'+res[i].goodsPrice+'</td>'+
                '</tr>'
            );
            $('#paytable').append(bigDiv);
            totalnum += res[i].goodsPrice;
        }
        var totalDiv = $('<td>'+
            '<th>总计:</th>'+
            '<td id="ptotalid">'+totalnum+'</td>'+
            '</tr>'
        );
        $('#totaltable').append(totalDiv);
        $('#ptotalid').attr("value",totalnum);
        /*var str='';
        str +='/balancePay?total=';
        str += totalnum;*/
        $('#paya').attr("value",totalnum);
    }
})
