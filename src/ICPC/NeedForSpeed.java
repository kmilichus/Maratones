
import java.io.*;
import java.util.StringTokenizer;

public class NeedForSpeed {
	
	
	public static int[] distance;
	public static int[] speed;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));
		
		
		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int T = Integer.parseInt(stk.nextToken());
		
		distance = new int[n];
		speed = new int[n];
		double low = -1e7;
		
		for (int i = 0; i < n; i++) {
			
			stk = new StringTokenizer(in.readLine());
			distance[i] = Integer.parseInt(stk.nextToken());
			speed[i] = Integer.parseInt(stk.nextToken());
			
			low = Math.max(low, -1.0*speed[i]);
		}
	
			
		
		double high = 1e7;
		
		
		for (int i = 0; i < 250; i++) {
			double mid = 0.5*(low+high);
			double sum = 0;
			for (int ii = 0; ii < n; ii++) {
				sum+= distance[ii]/(speed[ii]+mid);
			}
			
			if (sum>T) {
				low = mid;
			} else {
				high = mid;
			}
			
		}
			
		out.printf("%.9f", 0.5*(low+high));
		
	
		out.close();
		in.close();
	
	}

}
