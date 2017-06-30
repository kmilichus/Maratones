import java.io.*;
import java.util.*;

public class NPuzzle {




	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));

		
		
		char[][] puzzle = new char[4][4];
		
		int scatter = 0;
		
		for (int i = 0; i < puzzle.length; i++) {
			puzzle[i] = in.readLine().trim().toCharArray();			
			
			for (int j = 0; j < puzzle[i].length; j++) {
				
				
				char actual = puzzle[i][j];
				
				int pos = actual - 'A';
				
				int i1 = pos/4;
				int j1 = pos%4;
				
				if (actual != '.') {				
					scatter += ManhatanDistance(i,i1, j, j1);
				} 

				
				
			}
		
		}
	
		out.write(scatter+"\n");

		out.close();
		in.close();


	}

	 static int ManhatanDistance(int i, int i1, int j, int j1) {
		 
		 int dif = Math.abs(i-i1) + Math.abs(j-j1);
		 
		return Math.abs(dif);
	}
	
	
	


}