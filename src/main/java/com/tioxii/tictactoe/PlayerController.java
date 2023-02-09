package com.tioxii.tictactoe;

import com.tioxii.multiplayer.Channel;

public class PlayerController {
    Channel channel = null;
    TicTacToeGame game = null;

    public PlayerController(Channel channel, TicTacToeGame game) {
        this.channel = channel;
    }

    public void sendData(String data) {
        channel.getSession().getAsyncRemote().sendText(data);
    }

    @Event("turn")
    public void takeTurn(String data) {
        game.takeTurn(Integer.parseInt(data), this);
    }
}
