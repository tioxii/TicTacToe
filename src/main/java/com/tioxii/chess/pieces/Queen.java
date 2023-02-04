package com.tioxii.chess.pieces;

import java.util.ArrayList;

import com.tioxii.chess.Color;
import com.tioxii.chess.Piece;

public class Queen extends ChessPiece {
    
    public Queen(Color color) {
        super(color, Piece.QUEEN);
    }

    @Override
    public ArrayList<int[]> getPossibleMoves(int[] currentPos, ChessPiece[][] chessBoard) {
        ArrayList<int[]> possibleMoves = new ArrayList<>();

        //check if queen can move up
        for (int i = currentPos[1] + 1; i < 8; i++) {
            if (chessBoard[currentPos[0]][i].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0], i});
            }
            if (chessBoard[currentPos[0]][i].getColor() != Color.NONE) {
                break;
            }
        }

        //check if queen can move down
        for (int i = currentPos[1] - 1; i >= 0; i--) {
            if (chessBoard[currentPos[0]][i].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0], i});
            }
            if (chessBoard[currentPos[0]][i].getColor() != Color.NONE) {
                break;
            }
        }

        //check if queen can move right
        for (int i = currentPos[0] + 1; i < 8; i++) {
            if (chessBoard[i][currentPos[1]].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {i, currentPos[1]});
            }
            if (chessBoard[i][currentPos[1]].getColor() != Color.NONE) {
                break;
            }
        }

        //check if queen can move left
        for (int i = currentPos[0] - 1; i >= 0; i--) {
            if (chessBoard[i][currentPos[1]].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {i, currentPos[1]});
            }
            if (chessBoard[i][currentPos[1]].getColor() != Color.NONE) {
                break;
            }
        }

        //check if queen can move up and right
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
        
        //check if queen can move up and left
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

        //check if queen can move down and right
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

        //check if queen can move down and left
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
