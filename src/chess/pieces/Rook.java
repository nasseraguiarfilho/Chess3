package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {

		Board board = getBoard();
		int rows = board.getRows();
		int columns = board.getColumns();
		boolean[][] mat = new boolean[rows][columns];

		int rowRook = position.getRow();
		int columnRook = position.getColumn();

		// TODO falta verificar se a peca esta presa.

		for (int i = rowRook; i < rows; i++) {
			if (!board.thereIsAPiece(new Position(i, columnRook)))
				mat[i][position.getColumn()] = true;
			else
				break;
		}

		for (int i = rowRook; i >= 0; i--) {
			if (!board.thereIsAPiece(new Position(i, columnRook)))
				mat[i][position.getColumn()] = true;
			else
				break;
		}

		for (int i = columnRook; i < columns; i++) {
			if (!board.thereIsAPiece(new Position(rowRook, i)))
				mat[position.getRow()][i] = true;
			else
				break;
		}

		for (int i = columnRook; i >= 0; i--) {
			if (!board.thereIsAPiece(new Position(rowRook, i)))
				mat[position.getRow()][i] = true;
			else
				break;
		}

		return mat;

	}

}