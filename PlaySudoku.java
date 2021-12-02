import java.util.Scanner;

public class PlaySudoku {
	final int BOARD_SIZE = 9;
    final int SUBSECTION_SIZE = 3;
    final int BOARD_START_INDEX = 0;

    final int NO_VALUE = 0;
    final int MIN_VALUE = 1;
    final int MAX_VALUE = 9;

	void printBoard(int[][] board) {
		    for (int row = 0; row < 9; row++) {
		    	if (row % 3 == 0 && row != 0) {
    		        System.out.println("-------------------");
    		      }
            for (int column = 0; column < 9; column++) {
            	if (column % 3 == 0 && column != 0) {
    		        System.out.print("|");
    		      }
                System.out.print(board[row][column] + " ");
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
                if (board[usrrowValue][usrcolValue] == NO_VALUE) {
                	
                	System.out.println("\nNow type in the value...");
                	int mainvalue = scanner.nextInt();
                	if (mainvalue <= 9 && mainvalue >= 1) {
                		board[usrrowValue][usrcolValue] = mainvalue;
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