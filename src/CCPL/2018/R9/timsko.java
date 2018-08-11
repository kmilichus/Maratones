import java.io.*;
import java.util.StringTokenizer;

public class timsko {

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();


		while(line!=null) {

			StringTokenizer stk = new StringTokenizer(line);

			int M = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());
			
			
			int leaving_both = (M+N-K)/3;
			int leaving_girls = Math.min(M/2,N);

			int ans = Math.min(leaving_both,leaving_girls);
		
			
			out.write(ans+"\n");
	
			
			line = in.readLine();
			
		}	
		
		
		in.close();
		out.close();


	}




}
