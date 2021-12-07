import java.util.stream.IntStream;

public class Sudokuclass {
	
	boolean solver(final int[][] myInt) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (myInt[row][column] == 0) {
                    for (int k = 1; k <= 9; k++) {
                    	myInt[row][column] = k;
                        if (isValid(myInt, row, column) && solver(myInt)) {
                        	printBoard(myInt);
                        }
                        myInt[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
	
	void printBoard(int[][] myInt) {
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
				System.out.print(myInt[i][j]);
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
	
	private boolean isValid(int[][] myInt, int row, int column) {
        return rowCheck(myInt, row) &&
          columnCheck(myInt, column) &&
          subsectionConstraint(myInt, row, column);
    }

	private boolean subsectionConstraint(int[][] myInt, int row, int column) {
        boolean[] constraint = new boolean[9];
        int subsectionRowStart = (row / 3) * 3;
        int subsectionRowEnd = subsectionRowStart + 3;

        int subsectionColumnStart = (column / 3) * 3;
        int subsectionColumnEnd = subsectionColumnStart + 3;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!boxCheck(myInt, r, constraint, c)) return false;
            }
        }
        return true;
    }

    private boolean columnCheck(int[][] myInt, int column) {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9)
          .allMatch(row -> boxCheck(myInt, row, constraint, column));
    }

    private boolean rowCheck(int[][] myInt, int row) {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9)
          .allMatch(column -> boxCheck(myInt, row, constraint, column));
    }

    private boolean boxCheck(int[][] myInt, int row, boolean[] constraint, int column) {
        if (myInt[row][column] != 0) {
            if (!constraint[myInt[row][column] - 1]) {
                constraint[myInt[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

}
