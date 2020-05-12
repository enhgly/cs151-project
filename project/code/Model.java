package tictactoe;

public class Model {
	private int[][] gameBoard = new int[3][3];
	static int totalMoves = 0;

	public void setBoard(Integer field, NoughtCross value) {
		Integer placeVal = null;
		if (value == NoughtCross.O) {
			placeVal = 1;

		} else {
			placeVal = -1;
		}
		gameBoard[field % 3][field / 3] = placeVal;
		totalMoves++;
	}

	public void removeFromBoard(Integer field, NoughtCross value) {
		if(value == NoughtCross.O || value == NoughtCross.X) {
			gameBoard[field % 3][field / 3] = 0;
		}
		totalMoves--;
	}

	public boolean winCheck() {
		int sumDiagLR = 0;
		int sumDiagRL = 0;
		int sumCols = 0;
		int sumRows = 0;

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				sumCols += gameBoard[j][i];
				sumRows += gameBoard[i][j];
			}
			if (Math.abs(sumRows) == 3 || Math.abs(sumCols) == 3) {
				return true;
			}
			else {
				sumCols = 0;
				sumRows = 0;
			}
		}

		for (int i = 0; i <= 2; i++) {
			sumDiagRL += gameBoard[i][2 - i];
		}
		for (int i = 0; i <= 2; i++) {
			sumDiagLR += gameBoard[i][i];
		}
		return Math.abs(sumDiagLR) == 3 || Math.abs(sumDiagRL) == 3;
	}
}