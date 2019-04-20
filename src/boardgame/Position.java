package boardgame;

import exceptions.BoardException;

public class Position {
	
	private int row;
	private int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return row + ", " + column;
	}

	public void setValues(int row, int column) throws BoardException {
		if (validaRow(row) && validaColumn(column)) {
			this.row = row;
			this.column = column;
		} else
			throw new BoardException("Not a valid position!");
	}

	public boolean validaColumn(int num) {
		if (num >= 0 && num <= column) return true;
		return false;
	}

	public boolean validaRow(int num) {
		if (num >= 0 && num <= row) return true;
		return false;
	}

}
