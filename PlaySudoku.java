import java.util.Scanner;

public class PlaySudoku {

    final int NO_VALUE = 0;


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

    public void solve(int[][] board) {
    	Sudokuboard s2= new Sudokuboard();
    	int menuvalue;
    	Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\n1. enter location for row and column...\n2. I give up solve for me\n3. Exit game...");
            menuvalue = scanner.nextInt();
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
            	solveforme.solver(s2.board);
            	
            }
            else if(menuvalue<1|| menuvalue>3){
            	System.out.println("Please enter a correct option");
            }
        }while(menuvalue!=3);
        
        scanner.close();
    }
}