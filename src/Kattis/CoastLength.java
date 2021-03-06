import java.io.*;
import java.util.*;

public class CoastLength {
	
	static int [][] m;
	static int SEA = 2;


	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));



		StringTokenizer stk = new StringTokenizer(in.readLine());

		int rows = Integer.parseInt(stk.nextToken());
		int cols = Integer.parseInt(stk.nextToken());

		m = new int[rows+2][cols+2];

		for (int[] row: m)
		    Arrays.fill(row, 3);
		
		

		for (int i = 1; i <= rows; i++) {

			String linea = in.readLine();

			for (int j = 1; j <= cols; j++) {
				
				m[i][j]= Integer.parseInt(""+linea.charAt(j-1));	
			}
		}

		
		
		for (int i = 1; i <= rows; i++) {
			if (m[i][1] == 0) {
				m[i][1] = SEA;
				rec(i, 1);
			}
		}
		
		for (int i = 1; i <= rows; i++) {
			if (m[i][cols] == 0) {
				m[i][cols] = SEA;
				rec(i, cols);
			}
		}
		
		for (int j = 1; j <= cols; j++) {
			if (m[1][j] == 0) {
				m[1][j] = SEA;
				rec(1, j);
			}
		}
		
		for (int j = 1; j <= cols; j++) {
			if (m[rows][j] == 0) {
				m[rows][j] = SEA;
				rec(rows, j);
			}
		}

//		imprimir(m);
		

		// calculating perimeter
		
		int perimeter = 0;

		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= cols; j++) {

				if(m[i][j]== 1){

					if(m[i+1][j]== SEA || m[i+1][j]==3)
						perimeter++;	
					if(m[i-1][j]== SEA || m[i-1][j]==3)
						perimeter++;
					if(m[i][j+1]== SEA || m[i][j+1]==3)
						perimeter++;
					if(m[i][j-1]== SEA || m[i][j-1]==3)
						perimeter++;

//				System.out.println("i: "+i+ " j: "+j+" p: "+perimeter);

				}	
			}
		}

		out.write(perimeter+"\n");



		out.close();
		in.close();


	}
	
	
	static void rec(int i, int j){
		
		if(m[i+1][j]==0){	
			m[i+1][j]=SEA;
			rec(i+1,j);
		}
		if(m[i-1][j]==0){	
			m[i-1][j]=SEA;
			rec(i-1,j);
		}
		if(m[i][j+1]==0){	
			m[i][j+1]=SEA;
			rec(i,j+1);
		}
		if(m[i][j-1]==0){	
			m[i][j-1]=SEA;
			rec(i,j-1);
		}
		
	}
	
	
	
	
	static void imprimir( int[][] m ){
		
		for (int i = 0; i < m.length; i++) {
			
			for (int j = 0; j < m[0].length; j++) {
				
				System.out.print(m[i][j]+" ");
			}
			
			System.out.println();
		}
	}




}