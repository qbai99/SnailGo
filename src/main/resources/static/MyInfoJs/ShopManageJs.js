var shopId;

$.ajax({
    type:"GET",
    url:"/user/isSeller",
    success:function (res) {
        if (res.toString()=="true"){}
        else{
            $('#mainShop').css("display","none");
            var bigDiv = $('<div class="content-wrapper">' +
                '<div class="card-body">' +
                '<p>'+ "你还不是商家噢，如果想成为商家请点击下方链接"+'</p>' +
                '<a href="/">'+"我要成为商家"+'</a>' +
                '</div>' +
                '</div>');
            $('#mainContainer').append(bigDiv);
        }
    }
})
function changeConfirm(){
    var name = $('#shopName').val();
    var mbs = $('#mainBusiness').val();
    var loc = $('#location').val();
    var dsp = $('#introduction').val();
    $.ajax({
        type:"POST",
        url:"/shop/change",
        data:{
            shopId:shopId,
            name:name,
            mbs:mbs,
            loc:loc,
            dsp:dsp
        },
        success:function (res) {
            console.log(res);
            if (res.toString()=="true") alert("修改成功!");
            else alert("修改失败!");
            window.location.reload();

        }
    })
}

$.ajax({
    type:"GET",
    url:"/shop/information",
    success:function (res) {
        console.log(res);
        shopId = res.shop.shopId;
        $('#userImg').attr('src',res.user.userImg);
        $('#shopName').val(res.shop.shopName);
        $('#userName').html(res.user.userName);
        $('#goodsQuantity').html(res.goods.length);

        $('#mainBusiness').val(res.shop.shopMainBussiness);
        $('#location').val(res.shop.shopLoc);
        switch (parseInt(res.shop.shopStar)) {
            case 1:
                $('#star').html("★");
                break;
            case 2:
                $('#star').html("★★");
                break;
            case 3:
                $('#star').html("★★★");
                break;
            case 4:
                $('#star').html("★★★★");
                break;
            case 5:
                $('#star').html("★★★★★");
                break;
            default:
                break;
        }

        $('#introduction').val(res.shop.shopDsp);

        for(var i=0;i<res.goods.length;i++){
            var bigDiv = $('' +
                '<div class="post">' +
                // '<tr>' +
                // '<div class="user-block">' +
                // '    <img class="img-circle img-bordered-sm" src="'+res.user.userImg+'" alt="User Image">' +
                // '</div>' +
                // '<div class="row mb-3">' +
                // '    <div class="col-sm-6">' +
                // '        <img class="img-fluid" src="'+res.user.userImg+'" alt="Photo">' +
                // '    </div>' +
                '    <!-- /.col -->' +
                '    <div class="col-sm-6" style="position: center">' +
                '        <div class="row">' +
                '            <div class="col-sm-6">' +
                // '<td>          ' +
                '                <label class="description">商品名：'+ '<input style="text-align: center" value='+res.goods[i].goodsName+'></label>' +
                '                <p style="width:400%;"><label class="description">商品描述：</label><br>'+'<textarea style="width: 70%;height: 100px" id='+"dsp"+res.goods[i].goodsId+'></textarea></p>   ' +
                // '                <a href='+"/goods/details?id="+res.goods[i].goodsId+'>' +
                '                <label>商品图片</label>'+
                '                <img class="img-fluid mb-3" src='+"/goods_pics/"+res.goods[i].goodsId+"-pic-1.jpg"+' alt="Photo">' +
                // '                <img class="img-fluid" src="/AdminLTE-3.0.5/dist/img/photo3.jpg" alt="Photo">\n' +
                // '                </a> ' +
                '                <p style="width:400%;"><label>商品标签：</label>'+'<input style="text-align: center" value='+res.goods[i].goodsTag+'></p>   ' +
                '                <p style="width:400%;"><label>商品价格：</label>'+'<input style="text-align: center" value='+res.goods[i].goodsPrice+'></p>   ' +
                '                <p style="width:400%;"><label>商品库存：</label>'+'<input style="text-align: center" value='+res.goods[i].goodsRemaning+'></p>   ' +
                // '            </div>' +
                // '            <!-- /.col -->\n' +
                // '            <div class="col-sm-6">\n' +
                // '                <img class="img-fluid mb-3" src="/AdminLTE-3.0.5/dist/img/photo4.jpg" alt="Photo">\n' +
                // '                <img class="img-fluid" src="/AdminLTE-3.0.5/dist/img/photo1.png" alt="Photo">\n' +
                // '            </div>\n' +
                // '            <!-- /.col -->\n' +
                '        </div>' +
                // '        <!-- /.row -->' +
                '    </div>' +
                '    <!-- /.col -->' +
                '</div>\n' +
                '<p>' +
                // '     <a href="#" class="link-black text-sm mr-2"><i class="fas fa-share mr-1"></i> Share</a>\n' +
                // '     <a href="#" class="link-black text-sm"><i class="far fa-thumbs-up mr-1"></i> Like</a>\n' +
                // '        <a href="#">'+res.shop.shopName+'</a>' +
                '<span class="username">' +
                '    <a class="btn btn-info" href='+"/shop/deletegoods?goodsId="+ res.goods[i].goodsId+' class="float-right btn-tool">删除</a>' +
                '</span>' +
                // '<span class="float-right">\n' +
                '  <a href="#" class="btn btn-info" >' +
                '    修改' +
                '  </a>' +
                '  <a href="#" class="btn btn-info">' +
                '    上架' +
                '  </a>' +
                '  <a href="#" class="btn btn-info">\n' +
                '    下架' +
                '  </a>' +
                // '</span>' +
                '</p>' +
                //'<input class="form-control form-control-sm" type="text" placeholder="Type a comment">\n' +
                '</div>'
                // '</tr>'
                );
            $('#activity').append(bigDiv);
            $('#'+"dsp"+res.goods[i].goodsId).val(res.goods[i].goodsDsp);
        }
    }
})