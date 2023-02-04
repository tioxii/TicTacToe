package com.tioxii.chess.pieces;

import java.util.ArrayList;

import com.tioxii.chess.Color;
import com.tioxii.chess.Piece;

public class ChessPiece {
    private Color color = Color.NONE;
    private Piece piece = Piece.EMPTY;

    public ChessPiece() {}

    public ChessPiece(Color color, Piece piece) {

    }

    public final Color getColor() {
        return this.color;
    }

    public final Piece getPiece() {
        return this.piece;
    }

    public ArrayList<int[]> getPossibleMoves(int[] currentPos, ChessPiece[][] chessBoard) {
        return new ArrayList<>();
    }
}
