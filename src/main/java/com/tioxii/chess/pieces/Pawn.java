package com.tioxii.chess.pieces;

import java.util.ArrayList;

import com.tioxii.chess.Color;
import com.tioxii.chess.Piece;

public class Pawn extends ChessPiece {

    private boolean canBeEnPassanted = false;
    private boolean hasMoved = false;

    public Pawn(Color color) {
        super(color, Piece.PAWN);
    }

    @Override
    public ArrayList<int[]> getPossibleMoves(int[] currentPos, ChessPiece[][] chessBoard) {
        ArrayList<int[]> possibleMoves = new ArrayList<>();

        //check if pawn has reached the end of the board
        if (currentPos[1] == 0 || currentPos[1] == 7) {
            return possibleMoves;
        }
        
        int offSet = this.getColor() == Color.WHITE ? 1 : -1;

        //check if pawn can move forward
        if (chessBoard[currentPos[0]][currentPos[1] + offSet].getPiece() == Piece.EMPTY) {
            possibleMoves.add(new int[] {currentPos[0], currentPos[1] + offSet});
        }

        //check if pawn can move forward 2 spaces
        if (!hasMoved && chessBoard[currentPos[0]][currentPos[1] + offSet].getPiece() == Piece.EMPTY
            && chessBoard[currentPos[0]][currentPos[1] + offSet * 2].getPiece() == Piece.EMPTY) {
            possibleMoves.add(new int[] {currentPos[0], currentPos[1] + offSet * 2});
        }

        //check if pawn can move diagonally
        if (chessBoard[currentPos[0] + 1][currentPos[1] + offSet].getPiece() != Piece.EMPTY
            && chessBoard[currentPos[0] + 1][currentPos[1] + offSet].getColor() != this.getColor()) {
            possibleMoves.add(new int[] {currentPos[0] + 1, currentPos[1] + offSet});
        }

        if (chessBoard[currentPos[0] - 1][currentPos[1] + offSet].getPiece() != Piece.EMPTY
            && chessBoard[currentPos[0] + 1][currentPos[1] + offSet].getColor() != this.getColor()) {
            possibleMoves.add(new int[] {currentPos[0] - 1, currentPos[1] + offSet});
        }

        //check if pawn can be en passanted
        if (chessBoard[currentPos[0] + 1][currentPos[1]].getPiece() == Piece.PAWN
            && chessBoard[currentPos[0] + 1][currentPos[1]].getColor() != this.getColor()) {
            if(((Pawn) chessBoard[currentPos[0] + 1][currentPos[1]]).getCanBeEnPassanted())
                possibleMoves.add(new int[] {currentPos[0] + 1, currentPos[1] + offSet});
        }

        return possibleMoves;
    }

    public boolean getCanBeEnPassanted() {
        return this.canBeEnPassanted;
    }
}
