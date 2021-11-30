
public class print {{
	int rows, colms;
	rows=colms=9;
	int[][] arr = new int[rows][colms];
	for(int i = 0; i<rows; i++)
	{
		System.out.print(i+1+ " ");
	    for(int j = 0; j<colms; j++)
	    {
	    	if(j==0 || j==3 || j==6 ) {
	    		System.out.print(" | ");
	    	}
	        System.out.print(arr[i][j]);
	        if(j==8)
	        {
	        	System.out.print(" | ");
	        }
	    }
	    if(i==2 || i==5 || i==8)
	    {
	    	System.out.print("\n_________________________");
	    }
	    System.out.println();
	}	
}
}
