$.ajax({
    type:"POST",
    url:"/cartlist",
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    async:true,
    success:function (res,ifo) {
        console.log(res);
        for(var i = 0; i < res.length;i++) {
            var id=res[i].id;
            var num=res[i].goodsQuantity;
            if((res[i].goodsRemaning==null)){
                num=0;
            }else{
                if(res[i].goodsRemaning<res[i].goodsQuantity){
                    num=res[i].goodsRemaning;
                }
            }
            var badge1='<span class="badge badge-success">库存充足</span>';
            var badge2='<span class="badge badge-warning">即将售罄</span>';
            var badge3='<span class="badge badge-danger">已售罄</span>';
            var badge4='<span class="badge badge-secondary">已下架</span>';
            var badge ='';
            if (res[i].goodsRemaning >10){
                badge=badge1;
            }
            if (res[i].goodsRemaning <=10){
                badge=badge2;
            }
            if (res[i].goodsRemaning == 0){
                badge=badge3;
            }
            if (res[i].goodsRemaning == null){
                badge=badge4;
            }

            var bigDiv = $('<tr>' +
                '<td>' +
                '<div class="icheck-primary">' +
                '<input type="checkbox" name="cartitem" value='+res[i].id+' id='+"check"+res[i].id+'>'+
                '<label for='+"check"+res[i].id+'></label>'+
                '</div>'+
                '</td>'+
                '<td>'+
                '<a href='+"goods/details?id="+res[i].goodsId+'>'+
                '<img style="width:4vh;height: 4vh" src='+"/goods_pics/"+res[i].id+"-pic-1.jpg"+' class="product-image" alt="Product Image">'+
                ''+res[i].goodsName+''+
                '</a>'+
                '</td>'+
                '<td>'+
                '</td>'+
                '<td class="project_progress">'+
                '<div style="width: 160px">'+
                '<input style="width: 50px; height: 38px; border: 2px white; float: left;" type="button" value="-" onclick="reductionOf(this)" />'+
                '<input style="text-align: center; width: 50px; height: 32px; float: left;" type="text" id='+"in"+res[i].id+' value='+num+' onblur="checkNumber(this)" />'+
                '<input style="width: 50px; height: 38px; border: 2px white;" type="button" value="+" onclick="add(this,'+res[i].goodsRemaning+')" />'+
                '</div>'+
                '</td>'+
                '<td class="project-state">'+
                badge+
                '</td>'+
                '<td>'+
                ''+res[i].goodsPrice+''+
                '</td>'+
                '<td class="project-actions text-right" >'+
                '<a id='+"bj"+res[i].id+' class="btn btn-warning  btn-sm" href="#">'+
                '<img  src="/img/yen-2x.png"><img>'+
                '结算'+
                '</a>'+
                '<a class="btn btn-danger btn-sm" href='+"/cartdel?id="+res[i].id+'>'+
                '<i class="fas fa-trash">'+
                '</i>'+
                '删除'+
                '</a>'+
                '</td>'+
                '</tr>');


            $('#cartTable').append(bigDiv);
        }
        //console.log(res[0].id);
        var k=0;
        console.log($('#in'+res[k].id).val());
        for(var i = 0; i < res.length;i++) {
            var id=res[i].id;
            var str='/payone?id=';
            str +=id;
            str +='&num=';
            var vall=$('#in'+res[i].id).val();
            str +=vall;
            console.log(str);
            $('#bj'+res[i].id).attr('href',str)
            if((res[i].goodsRemaning==0)||(res[i].goodsRemaning==null)){
                $('#bj'+res[i].id).attr("disabled",true);
                $('#bj'+res[i].id).css("pointer-events","none");
            }
        }
    }
})
