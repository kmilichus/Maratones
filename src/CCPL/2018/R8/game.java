import java.io.*;
import java.util.StringTokenizer;

public class game {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		
		
		while (N!=0) {
			
			int xor = 0;
			
			StringTokenizer stk = new StringTokenizer(in.readLine());
			
			
			while (stk.hasMoreTokens()) {
			
				int x = Integer.parseInt(stk.nextToken());
				
				xor ^= x;
				
			}
			
			if(xor == 0){
				out.write("No\n");
			}else {
				out.write("Yes\n");
			}
			
			
			 N = Integer.parseInt(in.readLine());
		}

		
		in.close();
		out.close();
		
		
	}

}
