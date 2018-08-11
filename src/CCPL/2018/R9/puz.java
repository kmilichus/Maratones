import java.io.*;
import java.util.StringTokenizer;

public class puz {

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();


		while(line!=null) {

			StringTokenizer stk = new StringTokenizer(line);

			int climb = Integer.parseInt(stk.nextToken());
			int fall = Integer.parseInt(stk.nextToken());
			int goal = Integer.parseInt(stk.nextToken());

			
			int gap = goal - climb;
			
			int days = 1;
			
			
	
				
			days+= gap/ (climb-fall);
			
			if(gap% (climb-fall)!=0)
				days++;
				
				
			
		
			
			out.write(days+"\n");
			
			
			
			
			line = in.readLine();
			
		}	
		
		
		in.close();
		out.close();


	}




}
