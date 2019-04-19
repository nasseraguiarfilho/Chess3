package boardgame;

import exceptions.BoardException;

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
			throw new BoardException("Error! Position does NOT exist in the board.");
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position))
			throw new BoardException("Error! Position does NOT exist in the board.");
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position))
			throw new BoardException("There is already a piece on the position " + position);
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	public void removePiece(Position position) {
		pieces[position.getRow()][position.getColumn()] = null;
	}

	public boolean positionExists(Position position) {
		return position.getRow() >= 0 && position.getRow() < rows && position.getColumn() >= 0
				&& position.getColumn() < columns;
	}

	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position))
			throw new BoardException("Error! Position does NOT exist in the board.");
		return piece(position) != null;
	}

}
