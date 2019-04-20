package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private int turn;
	private Color currentPlayer;
	private boolean check;
	private boolean checkMate;
	private ChessPiece enPassantVulnerable;
	private ChessPiece promoted;

	private Board board;

	public ChessMatch() {
		turn = 0;
		currentPlayer = Color.WHITE;
		board = new Board(8,8);
		initialSetup();
	}
	
	
	
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
			
		}
		return mat;
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('c', 3, new King(board, Color.WHITE));
	}




	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

}
