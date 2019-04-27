package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;
import exceptions.BoardException;
import exceptions.ChessException;
import sun.swing.UIAction;
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

	public boolean isCheckMate() {
		return checkMate;
	}

	public Board getBoard() {
		return board;
	}

	public ChessPiece performChessMove(Color color, ChessPosition sourcePosition, ChessPosition targetPosition) {

		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();

		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		changeTurn(color);

		return (ChessPiece) capturedPiece;
	}

	private void changeTurn(Color color) {
		if (color == Color.WHITE)
			currentPlayer = Color.BLACK;
		if (color == Color.BLACK)
			currentPlayer = Color.WHITE;
		turn++;
	}

	private Piece makeMove(Position source, Position target) {

		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}

	private void validateSourcePosition(Position source) {
		if (!board.thereIsAPiece(source))
			throw new BoardException("There is no piece on source position!");
		
		if (!board.piece(source).isThereAnyPossibleMove()) throw new BoardException("Selected piece has no possible moves!");
	}
	

	public Color getCurrentPlayer(Color color) {
		return currentPlayer;
	}

	public void checkOwnPieces(Color color, ChessPosition source) {
		ChessPiece p = (ChessPiece) board.piece(source.toPosition());
		if (p.getColor() != color)
			throw new ChessException("It's not " + color + "'s piece!");
	}

	public void checkCurrentPlayer(Color color) {
		if (color != currentPlayer)
			throw new ChessException("It's not " + color + "'s turn!");
	}

	public void checkCaptureOwnPiece(Color color, ChessPosition target) {
		if (board.thereIsAPiece(target.toPosition())) {
			ChessPiece p = (ChessPiece) board.piece(target.toPosition());
			if (p.getColor() == color)
				throw new ChessException(
						"Cannot capture or move to " + target + " because there's a piece of yours there!");
		}
	}

	public void checkNullSource(ChessPosition source) {
		if (!board.thereIsAPiece(source.toPosition()))
			throw new ChessException("Position has no piece!");
	}
}
