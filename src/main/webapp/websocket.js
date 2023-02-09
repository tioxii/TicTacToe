/* WebSockets */
var ws;

function connect() {
    if(ws != null) {
        ws.close();
        document.getElementById('connect').innerHTML = 'Connect';
    }

    var hostname = document.location.host;
    var pathname = document.location.pathname;

    ws = new WebSocket("ws://" + hostname + pathname + "game");
    if(ws == null) {
        document.getElementById('connect').innerHTML = 'Disconnect';
    }
    

    ws.onmessage = function (event) {
        var data = JSON.parse(event.data);
        var message = data.content;

        for (var i = 0; i < cells.length; i++) {
            board[i] = message[i];
        }
        render();
    };

    ws.onclose = function (event) {
        board = [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '];
        render();
    }
}

function send(index) {
    var json = JSON.stringify({"turn": index});
    ws.send(json);
}

/* Tic Tac Toe */

var turn = 'X';
var gameover = false;
var board = [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '];

function render() {
    var cells = document.getElementsByClassName('cell');

    for (var i = 0; i < cells.length; i++) {
        cells[i].innerHTML = board[i];
    }
}

function handleClick(button) {
    var id = button.id.replace('cell-', '');;
    var index = parseInt(id);

    if(gameover)
        return;

    if (board[index] == ' ') {
        board[index] = turn;
        turn = turn == 'X' ? 'O' : 'X';
    }
    render();
    didSomeoneWin();
}

function reset() {
    var cells = document.getElementsByClassName('cell');
    for (var i = 0; i < cells.length; i++) {
        board[i] = ' ';
    }
    render();

    var status = document.getElementById('status');
    status.innerHTML = ' ';
    var reset = document.getElementById('reset');
    reset.innerHTML = 'Reset';
    gameover = false;
}

/* Check winning conditions */

function didSomeoneWin() {
    var reset = document.getElementById('reset');

    var row1 = board[0] + board[1] + board[2];
    var row2 = board[3] + board[4] + board[5];
    var row3 = board[6] + board[7] + board[8];

    var col1 = board[0] + board[3] + board[6];
    var col2 = board[1] + board[4] + board[7];
    var col3 = board[2] + board[5] + board[8];

    var diag1 = board[0] + board[4] + board[8];
    var diag2 = board[2] + board[4] + board[6];

    var status = document.getElementById('status');

    if (row1 == 'XXX' || row2 == 'XXX' || row3 == 'XXX' || col1 == 'XXX' || col2 == 'XXX' || col3 == 'XXX' || diag1 == 'XXX' || diag2 == 'XXX') {
        status.innerHTML = 'Player X has won!';
        gameover = true;
        reset.innerHTML = 'Play again?';
    }

    if (row1 == 'OOO' || row2 == 'OOO' || row3 == 'OOO' || col1 == 'OOO' || col2 == 'OOO' || col3 == 'OOO' || diag1 == 'OOO' || diag2 == 'OOO') {
        status.innerHTML = 'Player O has won!';
        gameover = true;
        reset.innerHTML = 'Play again?';
    }
    
    for(var i = 0; i < board.length; i++) {
        if(board[i] == ' ') 
            return;
    }

    if(!gameover) {
        status.innerHTML = 'It\'s a tie!';
        gameover = true;
    }
    reset.innerHTML = 'Play again?';
}