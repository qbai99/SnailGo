var stompClient = null;
function setConnected(connected) {
    document.getElementById("connect").disabled = connected;
    document.getElementById("disconnect").disabled = !connected;
    // document.getElementById("conversationDiv").style.visibility = connected ? 'visible' : 'hidden';
//        $("#connect").disabled = connected;
//        $("#disconnect").disabled = !connected;
    $("#response").html();
}
function connect() {
    var socket = new SockJS('/endpointSang');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        // setConnected(true);
        console.log('Connected:' + frame);
        stompClient.subscribe('/topic/getResponse', function (response) {
            showResponse(JSON.parse(response.body).responseMessage);
        })
    });
}
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log('Disconnected');
}
function sendName() {
    var name = $('#name').val();
    console.log('name:' + name);
    stompClient.send("/system", {}, JSON.stringify({'name': name}));
}
function showResponse(message) {
   $.Toast("消息推送", message, "success", {
       appendTo: "body",
       // is stackable?
       stack: false,
       // 'toast-top-left'
       // 'toast-top-right'
       // 'toast-top-center'
       // 'toast-bottom-left'
       // 'toast-bottom-right'
       // 'toast-bottom-center'
       position_class: "toast-top-right",
       // true = snackbar
       fullscreen: false,
       // width
       width: 250,
       // space between toasts
       spacing: 20,
       // in milliseconds
       timeout: 4000,
       // has close button
       has_close_btn: true,
       // has icon
       has_icon: true,
       // is sticky
       sticky: false,
       // border radius in pixels
       border_radius: 6,
       // has progress bar
       has_progress: false,
       // RTL support
       rtl: false
    });
}