import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Vestigium {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		StringTokenizer stk;
		int counter = 1;

		while(T-->0) {

			int n = Integer.parseInt(in.readLine());
			int k = 0;	int r = 0;	int c = 0;
			LinkedList<HashSet<String>> cols = new LinkedList<HashSet<String>>();
			
			for (int i = 0; i < n; i++) 
				cols.addFirst(new HashSet<String>());
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(in.readLine());
				HashSet<String> row = new HashSet<>();

				for (int j = 0; j < n; j++) {	
					String token = stk.nextToken();
					
					if(i==j) 
						k+= Integer.parseInt(token);
					
					cols.get(j).add(token);
					row.add(token);	
				}
				
				if (row.size()!=n) 
					r++;
				
			}

			for (int i = 0; i < n; i++) {
				if (cols.get(i).size()!=n) 
					c++;
			}
			out.write("Case #"+counter+": "+k+" "+r+" "+c+"\n");
			counter++;
		}

		out.flush();
		in.close();
		out.close();
	}
}
