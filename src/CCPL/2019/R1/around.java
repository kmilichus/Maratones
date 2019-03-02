import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class around {
	

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int C = Integer.parseInt(in.readLine());


		while(C-->0) {

			int roads = Integer.parseInt(in.readLine());

			StringTokenizer stk = new StringTokenizer(in.readLine());

			int starti = Integer.parseInt(stk.nextToken());
			int startj =  Integer.parseInt(stk.nextToken());

			stk = new StringTokenizer(in.readLine());

			int endi = Integer.parseInt(stk.nextToken());
			int endj =  Integer.parseInt(stk.nextToken());


			int bloqueos = Integer.parseInt(in.readLine());

			int[][][] m = new int[40][40][2];
			long[][] memo = new long[40][40];

			while(bloqueos-->0) {

				stk = new StringTokenizer(in.readLine());

				int i = Integer.parseInt(stk.nextToken());
				int j = Integer.parseInt(stk.nextToken());
				char d = stk.nextToken().charAt(0);
				int go = 0;	

				if(d == 'S') {
					j--;
					go = 1;		 
				}else if(d == 'W') {
					i--;
				}else if(d == 'N') {
					go = 1;					 
				}

				m[i][j][go] = 1;

			}

			memo[starti][startj] = 1;

		
			for(int i = starti; i <= endi; i++) {
				for(int j = startj; j <= endj; j++) {
					if(m[i][j][0]==0) {
						memo[i+1][j] += memo[i][j];	
//						System.out.println(memo[i][j]);
					}
					
					if(m[i][j][1]==0) {
						memo[i][j+1] += memo[i][j];
//						System.out.println(memo[i][j]);
					}
				}
			}
			
//			for (int i = 0; i < memo.length; i++) {
//				System.out.println(Arrays.toString(memo[i]));
//			}
			
			out.write(memo[endi][endj]+"\n");

		}
		
		


		in.close();
		out.close();

	}



}

