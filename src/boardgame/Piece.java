  package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Position position, Board board) {
		this.position = position;
		this.board = board;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	protected Board getBoard() {
		return board;
	}

	
	public abstract Piece[][] possibleMoves();
	
	public abstract boolean possibleMove(Position position);
	
	public abstract boolean isThereAnyPossibleMove();
	
	
}
