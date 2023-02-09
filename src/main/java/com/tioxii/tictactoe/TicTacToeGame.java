package com.tioxii.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class TicTacToeGame {
    private static TicTacToeGame instance = new TicTacToeGame();
    
    private String[] board = new String[9];
    private Set<PlayerController> players = new HashSet<>();
    private PlayerController playerO = null;
    private PlayerController playerX = null;
    private String turn = "X";

    private TicTacToeGame() {
        resetBoard();
    }

    public boolean takeTurn(int position, PlayerController playerController) {
        if (playerX != playerController && turn == "X")
            return false;
        if (playerO != playerController && turn == "O")
            return false;
        if (board[position] != " ")
            return false;
        
        board[position] = turn;
        turn = turn == "X" ? "O" : "X";
        return true;
    }

    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = " ";
        }
    }

    public void joinGame(PlayerController playerController) {
        if (playerO == null) {
            playerO = playerController;
        } else if (playerX == null) {
            playerX = playerController;
        }
        players.add(playerController);
    }

    public void leaveGame(PlayerController playerController) {
        if (playerO == playerController) {
            playerO = null;
        } else if (playerX == playerController) {
            playerX = null;
        }
        players.remove(playerController);
    }

    public static TicTacToeGame getInstance() {
        return instance;
    }

    public void sendBoard() {
        for (PlayerController playerController : players) {
            playerController.sendData(String.join("", board));
        }
    }
}
