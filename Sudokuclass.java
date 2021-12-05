import java.util.stream.IntStream;

public class Sudokuclass {
	
	boolean solver(final int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && solver(board)) {
                        	printBoard(board);
                        }
                        board[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
	
	void printBoard(int[][] board) {
		System.out.println("     123   456   789");
		System.out.println("----------------------");
		for(int i = 0; i<9; i++)
		{
			
			System.out.print(i+1+ " ");
			for(int j = 0; j<9; j++)
			{
				if(j==0 || j==3 || j==6 ) {
					System.out.print(" | ");
				}
				System.out.print(board[i][j]);
				if(j==8)
				{
					System.out.print(" | ");
				}
			}
			if(i==2 || i==5 || i==8)
			{
				System.out.print("\n----------------------");
			}
			System.out.println();
		}
    }
	
	private boolean isValid(int[][] board, int row, int column) {
        return rowCheck(board, row) &&
          columnCheck(board, column) &&
          subsectionConstraint(board, row, column);
    }

	private boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[9];
        int subsectionRowStart = (row / 3) * 3;
        int subsectionRowEnd = subsectionRowStart + 3;

        int subsectionColumnStart = (column / 3) * 3;
        int subsectionColumnEnd = subsectionColumnStart + 3;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!boxCheck(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    private boolean columnCheck(int[][] board, int column) {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9)
          .allMatch(row -> boxCheck(board, row, constraint, column));
    }

    private boolean rowCheck(int[][] board, int row) {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9)
          .allMatch(column -> boxCheck(board, row, constraint, column));
    }

    private boolean boxCheck(int[][] board, int row, boolean[] constraint, int column) {
        if (board[row][column] != 0) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

}
