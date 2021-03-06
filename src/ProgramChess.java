import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPosition;
import chess.Color;
import exceptions.ChessException;

public class ProgramChess {

	static Scanner sc = new Scanner(System.in);
	static ChessMatch chessMatch;

	public static void main(String[] args) {

		chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());

		do {

			playersTurn(Color.WHITE);
			updateBoard();

			playersTurn(Color.BLACK);
			updateBoard();

		} while (!chessMatch.isCheckMate());
	}

	private static void playersTurn(Color color) {

		try {
			
			chessMatch.checkCurrentPlayer(color);
			
			System.out.println();
			System.out.println(color + "'s turn.");
			System.out.print("Source: ");
			ChessPosition source = UI.ReadChessPosition(sc);
			
			
			boolean[][] possibleMoves = chessMatch.possibleMoves(source);
			UI.clearScreen();
			UI.printAvaliableOptions(chessMatch.getPieces(), possibleMoves);
			

			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.ReadChessPosition(sc);

			chessMatch.performChessMove(color, source, target);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			playersTurn(color);
		}

	}

	private static void updateBoard() {
		UI.printBoard(chessMatch.getPieces());
	}

}
