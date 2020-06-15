$.ajax({
    type: "POST",
    url: "/payBybalance",
    // data:JSON.stringify(dataObj) ,
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (res, ifo) {
        console.log(res);
        $("#financeID").attr('value',res[0].financeID);
        $("#userID").attr('value',res[0].userID);
        $("#balance").html(res[0].balance);
    }
});
