package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public Piece piece(int row, int column) {
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	public void removePiece(Position position) {
		pieces[position.getRow()][position.getColumn()] = null;
	}

	public boolean positionExists(Position position) {
		return (position.validaRow(this.rows) && position.validaColumn(this.columns));
	}

	public boolean thereIsAPiece(Position position) {
		if (!(pieces[position.getRow()][position.getColumn()] == null))
			return true;
		return false;
	}

}
