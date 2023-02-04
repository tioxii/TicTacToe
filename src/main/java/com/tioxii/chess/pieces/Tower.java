package com.tioxii.chess.pieces;

import java.util.ArrayList;

import com.tioxii.chess.Color;
import com.tioxii.chess.Piece;

public class Tower extends ChessPiece {
    
    public Tower(Color color) {
        super(color, Piece.TOWER);
    }

    @Override
    public ArrayList<int[]> getPossibleMoves(int[] currentPos, ChessPiece[][] chessBoard) {
        ArrayList<int[]> possibleMoves = new ArrayList<>();

        //check all to the left
        for (int i = currentPos[0] - 1; i >= 0; i--) {
            if (chessBoard[i][currentPos[1]].getPiece() == Piece.EMPTY) {
                possibleMoves.add(new int[] {i, currentPos[1]});
            } else {
                if (chessBoard[i][currentPos[1]].getColor() != this.getColor()) {
                    possibleMoves.add(new int[] {i, currentPos[1]});
                }
                break;
            }
        }

        //check all to the right
        for (int i = currentPos[0] + 1; i < 8; i++) {
            if (chessBoard[i][currentPos[1]].getPiece() == Piece.EMPTY) {
                possibleMoves.add(new int[] {i, currentPos[1]});
            } else {
                if (chessBoard[i][currentPos[1]].getColor() != this.getColor()) {
                    possibleMoves.add(new int[] {i, currentPos[1]});
                }
                break;
            }
        }

        //check all to the top
        for (int i = currentPos[1] - 1; i >= 0; i--) {
            if (chessBoard[currentPos[0]][i].getPiece() == Piece.EMPTY) {
                possibleMoves.add(new int[] {currentPos[0], i});
            } else {
                if (chessBoard[currentPos[0]][i].getColor() != this.getColor()) {
                    possibleMoves.add(new int[] {currentPos[0], i});
                }
                break;
            }
        }

        //check all to the bottom
        for (int i = currentPos[1] + 1; i < 8; i++) {
            if (chessBoard[currentPos[0]][i].getPiece() == Piece.EMPTY) {
                possibleMoves.add(new int[] {currentPos[0], i});
            } else {
                if (chessBoard[currentPos[0]][i].getColor() != this.getColor()) {
                    possibleMoves.add(new int[] {currentPos[0], i});
                }
                break;
            }
        }

        return possibleMoves;
    }
}
