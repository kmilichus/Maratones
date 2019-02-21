import java.io.*;
import java.util.StringTokenizer;

public class FlyingSquirrel {

	public static void main(String[] args) throws Exception {

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());

		int[] poles = new int[n];
	
		stk = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < n; i++) 
			poles[i]= Integer.parseInt(stk.nextToken());
		
		
		while(q-->0) {
			
			stk = new StringTokenizer(in.readLine());
			
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			
			
			if(end==0) { // Mayor cantidad de saltos empezando desde start
				
				//busq completa con DP
				
				
			}else { // Mayor cantidad de saltos empezando desde start y terminando en Y
				
				//Min max
				
			}
			
		}
		
	}

}
