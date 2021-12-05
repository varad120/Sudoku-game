import java.util.Scanner;

public class PlaySudoku {
	final int BOARD_SIZE = 9;
    final int SUBSECTION_SIZE = 3;
    final int BOARD_START_INDEX = 0;

    final int NO_VALUE = 0;
    final int MIN_VALUE = 1;
    final int MAX_VALUE = 9;

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

    public boolean solve(int[][] board) {
        while(true) {
        	Scanner scanner = new Scanner(System.in);
            System.out.println("\n1. enter location for row and column...\n2. I give up solve for me\n3. Exit game...");
            int menuvalue = scanner.nextInt();
            if(menuvalue == 1) {
            	System.out.println("\nNow type in the row value...");
                int usrrowValue = scanner.nextInt();
                System.out.println("\nNow type in the col value...");
                int usrcolValue = scanner.nextInt();
                if (board[(usrrowValue-1)][(usrcolValue-1)] == NO_VALUE) {
                	
                	System.out.println("\nNow type in the value...");
                	int mainvalue = scanner.nextInt();
                	if (mainvalue <= 9 && mainvalue >= 1) {
                		board[(usrrowValue-1)][(usrcolValue-1)] = mainvalue;
                		printBoard(board);
                	}
                	else {
                		System.out.println("enter value between 1 to 9");
                	}
                }
                else {
                	System.out.println("enter the correct location of row and column");
                }
                
            }
            else if (menuvalue == 2) {
            	System.out.println(2);
            	Sudokuclass solveforme = new Sudokuclass();
            	solveforme.solver(board);
            	
            }
            else {
            	System.out.println("Please enter a correct option");
            }
           		}
    	}
}