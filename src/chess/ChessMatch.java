package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.pieces.Bishop;
import chess.pieces.Horse;

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
		board = new Board(8, 8);
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
		placeNewSetOfPieces(Color.WHITE);
		placeNewSetOfPieces(Color.BLACK);
	}

	private void placeNewSetOfPieces(Color color) {
		int row = 1;
		if (color == Color.BLACK)
			row = 8;
		placeNewPiece('a', row, new Rook(board, color));
		placeNewPiece('b', row, new Horse(board, color));
		placeNewPiece('c', row, new Bishop(board, color));
		placeNewPiece('d', row, new King(board, color));
		placeNewPiece('e', row, new Queen(board, color));
		placeNewPiece('f', row, new Bishop(board, color));
		placeNewPiece('g', row, new Horse(board, color));
		placeNewPiece('h', row, new Rook(board, color));
		if (color == Color.BLACK)
			row--;
		else
			row++;
		placePawns(color, row);
	}

	private void placePawns(Color color, int row) {
		for (int i = 0; i < 8; i++) {
			placeNewPiece(((char) ('a' + (char) i)), row, new Pawn(board, color));
		}
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

}
