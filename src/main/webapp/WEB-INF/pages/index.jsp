<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <script type="text/javascript">
        var websocket;
        function connect() {
            var url = "";
            if (window.location.protocol == 'http:') {
                url = 'ws://' + window.location.host;
            } else {
                url = 'wss://' + window.location.host;
            }
            websocket = new WebSocket(url+"/chat/ws")
            //websocket.send("hello world");
            websocket.onopen = onFunOpen;

            websocket.onmessage = showMessage;
        }

        function onFunOpen(){
            alert('open');
        }

        function disconnect(){

        }

        function showMessage(event){
            alert(event.data);
        }

        function sendName(){
            var message = document.getElementById('name').value;
            websocket.send(message);
        }

    </script>
</head>
<body onload="disconnect()">
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <label>What is your name?</label><input type="text" id="name" />
        <button id="sendName" onclick="sendName();">Send</button>
        <p id="response"></p>
    </div>
</div>
</body>
</html>