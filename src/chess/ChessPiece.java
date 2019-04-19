package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class ChessPiece extends Piece {

	private Color color;
	private int moveCount;

	public int getMoveCount() {
		return moveCount;
	}

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	@Override
	public Piece[][] possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean possibleMove(Position position) {
		// TODO Auto-generated method stub
		return false;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public boolean isThereAnyPossibleMove() {
		// TODO Auto-generated method stub
		return false;
	}

	public ChessPosition getChessPosition() {
		return (ChessPosition) position;
	}

	public boolean isThereOpponentPiece(Position position) {
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
