package com.tioxii.chess.pieces;

import java.util.ArrayList;

import com.tioxii.chess.Color;
import com.tioxii.chess.Piece;

public class Knight extends ChessPiece {
    
    public Knight(Color color) {
        super(color, Piece.KNIGHT);
    }

    @Override
    public ArrayList<int[]> getPossibleMoves(int[] currentPos, ChessPiece[][] chessBoard) {
        ArrayList<int[]> possibleMoves = new ArrayList<>();

        //check if knight can move up 2 and right 1
        if (currentPos[1] + 2 < 8 && currentPos[0] + 1 < 8) {
            if (chessBoard[currentPos[0] + 1][currentPos[1] + 2].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0] + 1, currentPos[1] + 2});
            }
        }

        //check if knight can move up 2 and left 1
        if (currentPos[1] + 2 < 8 && currentPos[0] - 1 >= 0) {
            if (chessBoard[currentPos[0] - 1][currentPos[1] + 2].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0] - 1, currentPos[1] + 2});
            }
        }

        //check if knight can move up 1 and right 2
        if (currentPos[1] + 1 < 8 && currentPos[0] + 2 < 8) {
            if (chessBoard[currentPos[0] + 2][currentPos[1] + 1].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0] + 2, currentPos[1] + 1});
            }
        }

        //check if knight can move up 1 and left 2
        if (currentPos[1] + 1 < 8 && currentPos[0] - 2 >= 0) {
            if (chessBoard[currentPos[0] - 2][currentPos[1] + 1].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0] - 2, currentPos[1] + 1});
            }
        }

        //check if knight can move down 2 and right 1
        if (currentPos[1] - 2 >= 0 && currentPos[0] + 1 < 8) {
            if (chessBoard[currentPos[0] + 1][currentPos[1] - 2].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0] + 1, currentPos[1] - 2});
            }
        }

        //check if knight can move down 2 and left 1
        if (currentPos[1] - 2 >= 0 && currentPos[0] - 1 >= 0) {
            if (chessBoard[currentPos[0] - 1][currentPos[1] - 2].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0] - 1, currentPos[1] - 2});
            }
        }

        //check if knight can move down 1 and right 2
        if (currentPos[1] - 1 >= 0 && currentPos[0] + 2 < 8) {
            if (chessBoard[currentPos[0] + 2][currentPos[1] - 1].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0] + 2, currentPos[1] - 1});
            }
        }

        //check if knight can move down 1 and left 2
        if (currentPos[1] - 1 >= 0 && currentPos[0] - 2 >= 0) {
            if (chessBoard[currentPos[0] - 2][currentPos[1] - 1].getColor() != this.getColor()) {
                possibleMoves.add(new int[] {currentPos[0] - 2, currentPos[1] - 1});
            }
        }

        return possibleMoves;
    }    
}
