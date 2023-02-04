package com.tioxii.chess.pieces;

import java.util.ArrayList;

import com.tioxii.chess.Color;
import com.tioxii.chess.Piece;

public class Bishop extends ChessPiece {

    public Bishop(Color color) {
        super(color, Piece.BISHOP);
    }

    @Override
    public ArrayList<int[]> getPossibleMoves(int[] currentPos, ChessPiece[][] chessBoard) {
        ArrayList<int[]> possibleMoves = new ArrayList<>();

        //check if bishop can move up and right
        for (int i = 1; i < 8; i++) {
            if (currentPos[0] + i < 8 && currentPos[1] + i < 8) {
                if (chessBoard[currentPos[0] + i][currentPos[1] + i].getColor() != this.getColor()) {
                    possibleMoves.add(new int[] {currentPos[0] + i, currentPos[1] + i});
                }
                if (chessBoard[currentPos[0] + i][currentPos[1] + i].getColor() != Color.NONE) {
                    break;
                }
            }
        }

        //check if bishop can move up and left
        for (int i = 1; i < 8; i++) {
            if (currentPos[0] - i >= 0 && currentPos[1] + i < 8) {
                if (chessBoard[currentPos[0] - i][currentPos[1] + i].getColor() != this.getColor()) {
                    possibleMoves.add(new int[] {currentPos[0] - i, currentPos[1] + i});
                }
                if (chessBoard[currentPos[0] - i][currentPos[1] + i].getColor() != Color.NONE) {
                    break;
                }
            }
        }

        //check if bishop can move down and right
        for (int i = 1; i < 8; i++) {
            if (currentPos[0] + i < 8 && currentPos[1] - i >= 0) {
                if (chessBoard[currentPos[0] + i][currentPos[1] - i].getColor() != this.getColor()) {
                    possibleMoves.add(new int[] {currentPos[0] + i, currentPos[1] - i});
                }
                if (chessBoard[currentPos[0] + i][currentPos[1] - i].getColor() != Color.NONE) {
                    break;
                }
            }
        }

        //check if bishop can move down and left
        for (int i = 1; i < 8; i++) {
            if (currentPos[0] - i >= 0 && currentPos[1] - i >= 0) {
                if (chessBoard[currentPos[0] - i][currentPos[1] - i].getColor() != this.getColor()) {
                    possibleMoves.add(new int[] {currentPos[0] - i, currentPos[1] - i});
                }
                if (chessBoard[currentPos[0] - i][currentPos[1] - i].getColor() != Color.NONE) {
                    break;
                }
            }
        }

        return possibleMoves;
    }
}
