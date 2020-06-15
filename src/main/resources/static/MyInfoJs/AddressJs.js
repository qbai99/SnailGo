$.ajax({
    type:"POST",
    url:"/address/myaddress",
    success:function (res) {
        console.log(res);
    }
})