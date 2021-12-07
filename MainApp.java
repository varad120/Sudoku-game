public class MainApp {

	public static void main(String[] args) {
		
	    
		Sudokuboard s1= new Sudokuboard();
	    PlaySudoku solver = new PlaySudoku();
	   	solver.printBoard(s1.board);
	   	solver.solve(s1.board);
	   	System.out.println("-----Game exited----- \nThank you for playing this game");

	
	}

}