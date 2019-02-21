import java.io.*;
import java.util.StringTokenizer;

public class BusStop {

	public static void main(String[] args) throws Exception {

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-->0) {
			int houses = Integer.parseInt(in.readLine());
			
			if(houses!=0) {
			int[] dist = new int[houses];
			
			StringTokenizer stk = new StringTokenizer(in.readLine());
			
			int gap = 20;
			int stations = 0;
			
			int current = Integer.parseInt(stk.nextToken());
			int start = current;
			dist[0]=current;
			
			for (int i = 1; i < houses; i++) {
				current = Integer.parseInt(stk.nextToken());
				dist[i]=current;
				
				if(current-start>gap) {
					stations++;
//					System.out.println("start " +start + " current "+current + " sta "+stations);
					start = current;
					
				}				
			}
				
			if(current==dist[houses-1])
				stations++;
			
			out.write(stations+"\n");
		}else {
			in.readLine();
			out.write("0\n");
		}
			
		}
	
		out.close();
		in.close();
	}

}
