var ws;

function connect() {
    var username = document.getElementById("username").value;

    var hostname = document.location.host;
    var pathname = document.location.pathname;

    ws = new WebSocket("ws://" + hostname + pathname + "chat");

    ws.onmessage = function (event) {
        var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.content + " : " + message.content + "\n";
    };
}

function send() {
    var message = document.getElementById("msg").value;
    var json = JSON.stringify({"content": message});
    ws.send(json);
}