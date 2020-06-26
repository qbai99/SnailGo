$.ajax({
    type: "POST",
    url: "/getaddress",
    // data:JSON.stringify(dataObj) ,
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (res, ifo) {
        console.log(res);

    }
});
