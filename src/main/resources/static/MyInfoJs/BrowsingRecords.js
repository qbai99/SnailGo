var userEmail = document.cookie.split('=')[6];
$.ajax({
    type:"GET",
    url:"/Records/getrecords",
    data:{
        userAdmin:userEmail
    },
    success:function (res) {
        console.log(res);
    }
})