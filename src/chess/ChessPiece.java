package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

	private Color color;
	private int moveCount;

	public int getMoveCount() {
		return moveCount;
	}

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereOpponentPiece(Position position) {
		Board board = this.getBoard();
		return board.thereIsAPiece(position);

	}

	public void increaseMove() {
		moveCount++;
	}

	public void decreaseMove() {
		moveCount--;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
