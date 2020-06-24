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


$.ajax({
    type:"GET",
    url:"/shop/information",
    success:function (res) {
        console.log(res);
        $('#userImg').attr('src',res.user.userImg);
        $('#shopName').html(res.shop.shopName);
        $('#userName').html(res.user.userName);
        $('#goodsQuantity').html(res.goods.length);

        $('#mainBusiness').html(res.shop.shopMainBussiness);
        $('#location').html(res.shop.shopLoc);
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

        $('#introduction').html(res.shop.shopDsp);

        for(var i=0;i<res.goods.length;i++){
            var bigDiv = $('' +
                '<div class="post">' +
                '<div class="user-block">' +
                '    <img class="img-circle img-bordered-sm" src="'+res.user.userImg+'" alt="User Image">' +
                '    <span class="username">' +
                '        <a href="#">'+res.shop.shopName+'</a>' +
                '        <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>' +
                '    </span>' +
                '</div>' +
                '<div class="row mb-3">' +
                // '    <div class="col-sm-6">' +
                // '        <img class="img-fluid" src="'+res.user.userImg+'" alt="Photo">' +
                // '    </div>' +
                '    <!-- /.col -->' +
                '    <div class="col-sm-6">' +
                '        <div class="row">' +
                '            <div class="col-sm-6">' +
                '                <label class="description">'+ res.goods[i].goodsName+'</label>' +
                '                <p style="width:400%;">'+res.goods[i].goodsDsp+'</p>   ' +
                '                <a href='+"/goods/details?id="+res.goods[i].goodsId+'>'+
                '                <img class="img-fluid mb-3" src='+"/goods_pics/"+res.goods[i].goodsId+"-pic-1.jpg"+' alt="Photo">' +
                // '                <img class="img-fluid" src="/AdminLTE-3.0.5/dist/img/photo3.jpg" alt="Photo">\n' +
                '                </a> ' +
                ' </div>' +
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
                '     <a href="#" class="link-black text-sm mr-2"><i class="fas fa-share mr-1"></i> Share</a>\n' +
                '     <a href="#" class="link-black text-sm"><i class="far fa-thumbs-up mr-1"></i> Like</a>\n' +
                '     <span class="float-right">\n' +
                // '  <a href="#" class="link-black text-sm">\n' +
                // '    <i class="far fa-comments mr-1"></i> Comments (5)\n' +
                // '  </a>' +
                '</span>' +
                '</p>' +
                //'<input class="form-control form-control-sm" type="text" placeholder="Type a comment">\n' +
                '</div>');
            $('#activity').append(bigDiv);
        }
    }
})