$.ajax({
    type: "GET",
    url: "/user/information",
    success: function (res, ifo) {
        $('#sideImg').attr('src', res.UserInfo[0].userImg);
        $("#sideName").attr('value', res.UserInfo[0].userName);
    }
});
$.ajax({
    type:"GET",
    url:"/Records/getrecords",
    // data:{
    //     userAdmin:userEmail
    // },
    success:function (res) {
        console.log(res);
        for(var i = 0;i<res.BrowsingRecords.length;i++){
            var bigDiv = $('<tr>' +
                '<td>'+
                '<a href='+"/goods/details?id="+res.GoodsInfo[i].goodsId+'>'+
                '<img style="width:4vh;height: 4vh" src='+"/goods_pics/"+res.GoodsInfo[i].goodsId+"-pic-1.jpg"+' class="product-image" alt="Product Image">'+
                ''+res.GoodsInfo[i].goodsName+''+
                '</a>'+
                '</td>'+
                '<td>'
                + res.GoodsInfo[i].goodsDsp+
                '</td>'+
                '<td>'
                 + res.GoodsInfo[i].goodsTag+
                '</td>'+
                '<td>'+
                res.GoodsInfo[i].goodsPrice+
                '</td>'+
                '<td class="project-actions text-right" >'+
                '<a class="btn btn-danger btn-sm" href='+"/Records/deleterecords?recordsId="+res.BrowsingRecords[i].recordsId+'>'+
                '<i class="fas fa-trash">'+
                '</i>'+
                '删除'+
                '</a>'+
                '</td>'+
                '</tr>');

            $('#historyTable').append(bigDiv);
        }

    }
})