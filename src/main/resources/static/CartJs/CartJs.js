$.ajax({
    type:"POST",
    url:"/cartlist",
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success:function (res,ifo) {

        console.log(res);
        for(var i = 0; i < res.length;i++) {
            var bigDiv = $('<tr>' +
                '<td>' +
                '<div class="icheck-primary">' +
                '<input type="checkbox" value='+res[i].id+' id='+"check"+res[i].id+'>'+
                '<label for='+"check"+res[i].id+'></label>'+
                '</div>'+
                '</td>'+
                '<td>'+
                '<a href='+"goods/details?id="+res[i].goodsID+'>'+
                '<img style="width:4vh;height: 4vh" src='+"/goods_pics/"+res[i].id+"-pic-1.jpg"+' class="product-image" alt="Product Image">'+
                ''+res[i].goodsName+''+
                '</a>'+
                '</td>'+
                '<td>'+
                '</td>'+
                '<td class="project_progress">'+
                '<div style="width: 160px">'+
                '<input style="width: 50px; height: 38px; border: 2px white; float: left;" type="button" value="-" onclick="reductionOf(this)" />'+
                '<input style="text-align: center; width: 50px; height: 32px; float: left;" type="text" value="1" onblur="checkNumber(this)" />'+
                '<input style="width: 50px; height: 38px; border: 2px white;" type="button" value="+" onclick="add(this)" />'+
                '</div>'+
                '</td>'+
                '<td class="project-state">'+
                '<span class="badge badge-success">库存充足</span>'+
                '</td>'+
                '<td>'+
                ''+res[i].goodsPrice+''+
                '</td>'+
                '<td class="project-actions text-right">'+
                '<a class="btn btn-warning  btn-sm" href="#">'+
                '<img  src="/img/yen-2x.png"><img>'+
                '结算'+
                '</a>'+
                '<a class="btn btn-danger btn-sm" href="#">'+
                '<i class="fas fa-trash">'+
                '</i>'+
                '删除'+
                '</a>'+
                '</td>'+
                '</tr>');
            $('#cartTable').append(bigDiv);
        }
    }
})