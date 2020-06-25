$(document).ready(function () {
    bsCustomFileInput.init();
    if($.cookie("username")==null){

    };
});
var goodsid=[[${goodsdetails[0].goodsId}]];
console.log(goodsid);

function myclick() {

    function getCookie(c_name) {
        if (document.cookie.length > 0) {
            c_start = document.cookie.indexOf(c_name + "=");
            if (c_start != -1) {
                c_start = c_start + c_name.length + 1;
                c_end = document.cookie.indexOf(";", c_start);
                if (c_end == -1) c_end = document.cookie.length;
                return unescape(document.cookie.substring(c_start, c_end));
            }
        }
        return "";
    }
    a=getCookie("username");
    c_start=document.cookie.indexOf("username=");
    console.log(c_start)
    if(c_start == -1){
        window.location.href="/loginPage";
    }

}

