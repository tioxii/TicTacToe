package com.tioxii.chess;

import java.io.Serializable;
import java.util.ArrayList;

import com.tioxii.chess.pieces.ChessPiece;

public class ChessBoard implements Serializable {
    
    ChessPiece[][] chessBoard = new ChessPiece[8][8];
    boolean isWhiteTurn = true;

    private class ChessField {
        private ChessPiece piece;
    }


    //TODO fill with chess pieces
    public ChessBoard() {
        
    }

    public boolean validateMove(int[] from, int[] to) {
        ArrayList<int[]> possibleMoves = chessBoard[from[0]][from[1]].getPossibleMoves(from, chessBoard);
        possibleMoves = (ArrayList<int[]>) possibleMoves.stream().filter(move -> move[0] == to[0] && move[1] == to[1]).toList();
        
        if (possibleMoves.size() > 0) {
            return true;
        }
        return false;
    }

    public void makeMove(int[] from, int[] to) {
        if (validateMove(from, to)) {
            chessBoard[to[0]][to[1]] = chessBoard[from[0]][from[1]];
            chessBoard[from[0]][from[1]] = new ChessPiece();
            flipTurn();
        }
    }

    private void flipTurn() {
        isWhiteTurn = !isWhiteTurn;
    }
}
