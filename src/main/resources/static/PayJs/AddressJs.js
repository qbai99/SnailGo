$.ajax({
    type: "POST",
    url: "/getaddress",
    // data:JSON.stringify(dataObj) ,
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (res, ifo) {
        console.log(res);
        var k=0;
        var strr=' ';
        var rowDiv=$('<div style="width:100%">'+strr+'</div>');
        var miniDiv=$('<div style="width:5%">'+strr+'</div>');
        for(var i=0;i<res.length;i++){
            var addre=new Array();
            addre=res[i].address.split('/');
            console.log(addre);
            var bigDiv1= $('<div id='+res[i].addressId+' style="width:30%" class="callout callout-danger">'+
                '<h5>'+addre[0]+addre[1]+'('+addre[5]+')收'+'</h5>'+
                '<p>'+addre[2]+' '+addre[3]+'</p>'+
                '<p>'+addre[4]+'</p>'+
                '<div class="icheck-danger d-inline">'+
                '<input name="r2" id='+"radio"+res[i].addressId+' type="radio" value='+res[i].addressId+'>'+
                '<label for='+"radio"+res[i].addressId+'></label>'+
                '</div>'+
                '</div>'+
                '<div style="width:5%">'+strr+'</div>'
            );
            var bigDiv2= $('<div id='+res[i].addressId+' style="width:30%" class="callout callout-danger">'+
                '<h5>'+addre[0]+addre[1]+'('+addre[5]+')收'+'</h5>'+
                '<p>'+addre[2]+' '+addre[3]+'</p>'+
                '<p>'+addre[4]+'</p>'+
                '<div class="icheck-danger d-inline">'+
                '<input name="r2" id='+"radio"+res[i].addressId+' type="radio" value='+res[i].addressId+'>'+
                '<label for='+"radio"+res[i].addressId+'></label>'+
                '</div>'+
                '</div>'+
                '<div style="width:100%">'+strr+'</div>'
            );
            /*$('#addressdivid').append(bigDiv);
            $('#5').after(miniDiv);*/
            //console.log();
            if(((i+1)%3==1)||((i+1)%3==2)){
                console.log("111");
                /*console.log(res[i].addressId);
                $('#'+res[i].addressId).after(miniDiv);
                console.log(res[i].addressId);*/
                $('#addressdivid').append(bigDiv1);

            }else if(((i+1)%3==0)){
                console.log("222");
                /*console.log(res[i].addressId);
                $('#'+res[i].addressId).after(rowDiv);
                console.log(res[i].addressId);*/
                $('#addressdivid').append(bigDiv2);
            }
        }
        $('#radio'+res[0].addressId).attr("checked",true);
    }
});
