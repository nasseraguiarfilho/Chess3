package boardgame;

import exceptions.BoardException;
import exceptions.ChessException;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1)
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column))
			throw new BoardException("Error! Position does not exist on the board.");
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position))
			throw new BoardException("Error! Position does not exist on the board.");
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position))
			throw new BoardException("There is already a piece on the position " + position);
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	public Piece removePiece(Position position) {

		Piece pieceRemoved = null;

		if ((!positionExists(position))) {
			throw new BoardException("Position not on the board");
		}
		if (!thereIsAPiece(position)) {
			return pieceRemoved;
		}

		pieceRemoved = pieces[position.getRow()][position.getColumn()];
		pieces[position.getRow()][position.getColumn()] = null;

		return pieceRemoved;

	}

	public boolean positionExists(Position position) {
		return position.getRow() >= 0 && position.getRow() < rows && position.getColumn() >= 0
				&& position.getColumn() < columns;
	}

	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean thereIsAPiece(Position position) {
		if (pieces[position.getRow()][position.getColumn()] != null)
			return true;
		return false;
	}

}
