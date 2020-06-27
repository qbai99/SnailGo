var shopId;

var binaryFile;

var fileList = new Array();

function check(){
    console.log($('#imgFile').val());
    var reads = new FileReader();
    console.log(document.getElementById('imgFile').files);
    var f = document.getElementById('imgFile').files[0];
    reads.readAsDataURL(f);
    reads.onload = function (e) {
        binaryFile = this.result;
        console.log("上传图片"+this.result);
        $('#preview').attr('src',this.result);
        // console.log(f);
    }

}

$.ajax({
    type:"GET",
    url:"/user/isSeller",
    success:function (res) {
        if (res.toString()=="true"){}
        else{
            $('#mainShop').css("display","none");
            var bigDiv = $('<div class="content-wrapper">' +
                '<div class="card-body">' +
                '<p>'+ "你还不是商家噢"+'</p>' +
                '<a href="/">'+"我要成为商家"+'</a>' +
                '</div>' +
                '</div>');
            $('#mainContainer').append(bigDiv);
        }
    }
})
$.ajax({
    type: "GET",
    url: "/user/information",
    success: function (res, ifo) {
        $('#sideImg').attr('src', res.UserInfo[0].userImg);
        $("#sideName").html( res.UserInfo[0].userName);
    }
});
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
                '                <label class="description">商品名：'+ '<input style="text-align: center" id='+"name"+res.goods[i].goodsId +'></label>' +
                '                <p style="width:400%;"><label class="description">商品描述：</label><br>'+'<textarea style="width: 70%;height: 100px" id='+"dsp"+res.goods[i].goodsId+'></textarea></p>   ' +
                // '                <a href='+"/goods/details?id="+res.goods[i].goodsId+'>' +
                '                <label>商品图片</label>'+
                '                <img class="img-fluid mb-3" src='+res.img[i].goodsImg+' alt="Photo" id='+"goodsimg"+res.goods[i].goodsId+'>' +
                '                <input placeholder="点我更换图片" type="file" id="'+"imgFile"+res.goods[i].goodsId+"/"+i+'" accept="image/jpg,image/jpeg,img/png,img/PNG" onchange="changeImg(this)">' +
                // <a id='+"changeImg"+res.goods[i].goodsId+'' +
                // '                class="btn btn-info" style="color:white;" onclick="changeImg(this)">' +
                // '                  更换图片</a>' +
                // '                <img class="img-fluid" src="/AdminLTE-3.0.5/dist/img/photo3.jpg" alt="Photo">\n' +
                // '                </a> ' +
                '                <p style="width:400%;"><label>商品标签：</label>'+'<input style="text-align: center" id='+"tag"+res.goods[i].goodsId + '></p>   ' +
                '                <p style="width:400%;"><label>商品价格：</label>'+'<input style="text-align: center" id='+"price"+res.goods[i].goodsId + '></p>   ' +
                '                <p style="width:400%;"><label>商品库存：</label>'+'<input style="text-align: center" id='+"remain"+res.goods[i].goodsId + '></p>   ' +
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
                // '<span class="username">' +
                // '</span>' +
                // '<span class="float-right">\n' +
                '  <a id='+"change"+res.goods[i].goodsId+"/" +i+
                // 'href="'+"/shop/changeinfo?goodsId="+res.goods[i].goodsId+
                // // "&name="+$('#'+"name"+res.goods[i].goodsId).val()+
                // "&name="+res.goods[i].goodsName+
                // "&dsp="+$('#'+"dsp"+res.goods[i].goodsId).val()+
                // "&tag="+$('#'+"tag"+res.goods[i].goodsId).val()+
                // "&price="+$('#'+"price"+res.goods[i].goodsId).val()+
                // "&remain="+$('#'+"remain"+res.goods[i].goodsId).val()+
                ' class="btn btn-info" onclick="change(this)" style="color: white;">' +
                '    修改' +
                '  </a>' +
                // '  <a href="#" class="btn btn-info">' +
                // '    上架' +
                // '  </a>' +
                // '  <a href="#" class="btn btn-info">\n' +
                // '    下架' +
                // '  </a>' +
                '  <a class="btn btn-info" href='+"/shop/deletegoods?goodsId="+ res.goods[i].goodsId+'>' +
                '    删除' +
                '  </a>' +
                // '</span>' +
                '</p>' +
                //'<input class="form-control form-control-sm" type="text" placeholder="Type a comment">\n' +
                '</div>'
                // '</tr>'
                );
            $('#activity').append(bigDiv);
            $('#'+"dsp"+res.goods[i].goodsId).val(res.goods[i].goodsDsp);
            $('#'+"name"+res.goods[i].goodsId).val(res.goods[i].goodsName);
            $('#'+"tag"+res.goods[i].goodsId).val(res.goods[i].goodsTag);
            $('#'+"price"+res.goods[i].goodsId).val(res.goods[i].goodsPrice);
            $('#'+"remain"+res.goods[i].goodsId).val(res.goods[i].goodsRemaning);
            fileList.push(res.img[i].goodsImg);
        }
        console.log(fileList);
    }
})

function AddGoods() {
    var goodsName = $('#goodsName').val();
    var goodsIntro = $('#goodsIntro').val();
    var goodsTag = $('#goodsTag').val();
    var goodsPrice = $('#goodsPrice').val();
    var goodsRemain = $('#goodsRemain').val();

    $.ajax({
        type:"POST",
        url:"/shop/addgoods",
        data:{
            shopId:shopId,
            goodsName:goodsName,
            goodsIntro:goodsIntro,
            goodsTag:goodsTag,
            goodsPrice:goodsPrice,
            goodsRemain:goodsRemain,
            file:binaryFile
        },
        success:function (res) {
            if (res.toString()=="true"){
                alert("添加成功！");
                window.location.reload();
            }
            else alert("添加失败！");
        }

    })
}

function changeImg(e) {
    console.log(e);
    var goodsid = e.id.split("imgFile")[1].split("/")[0];
    var arrayIndex = e.id.split("imgFile")[1].split("/")[1];
    console.log(goodsid);
    console.log(arrayIndex);
    var reads = new FileReader();
    console.log(document.getElementById(e.id).files);
    var f = document.getElementById(e.id).files[0];
    reads.readAsDataURL(f);
    reads.onload = function (e) {
        fileList[arrayIndex] = this.result;
        console.log("上传图片"+this.result);
        $('#'+"goodsimg"+goodsid).attr('src',this.result);
        // console.log(f);
    }

}
function change(e) {
    var goodsid = e.id.split("change")[1].split("/")[0];
    var index = e.id.split("change")[1].split("/")[1];
    console.log(goodsid);
    console.log(index);
    console.log("新图片"+fileList[index]);

    var goodsName = $('#'+"name"+goodsid).val();
    var goodsDsp = $('#'+"dsp"+goodsid).val();
    var goodsTag = $('#'+"tag"+goodsid).val();
    var goodsPrice = $('#'+"price"+goodsid).val();
    var goodsRemain = $('#'+"remain"+goodsid).val();
    console.log($('#'+"dsp"+goodsid).val());

    $.ajax({
        type:"POST",
        url:"/shop/changeinfo",
        data:{
            goodsId:goodsid,
            name:goodsName,
            dsp:goodsDsp,
            tag:goodsTag,
            price:goodsPrice,
            remain:goodsRemain,
            file:fileList[index]
        },
        success:function (res) {
            alert("修改成功！");
            window.location.reload();
        }
    })
}




