$.ajax({
    type:"GET",
    url:"/shop/information",
    success:function (res) {
        console.log(res);
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
    }
})