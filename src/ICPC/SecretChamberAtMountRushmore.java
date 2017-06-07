
import java.io.*;
import java.util.StringTokenizer;

public class SecretChamberAtMountRushmore {
	
	
	public static int[][] graph;
	public static char a = 'a';
	

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));
		
		
		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int m = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());
		
		graph = new int[26][26];


		
		while (m-->0) {
			stk = new StringTokenizer(in.readLine());	
			char x = stk.nextToken().charAt(0);
			char y = stk.nextToken().charAt(0);
			graph[x-a][y-a] =1;
		
		}
		
		for (int i = 0; i < 26; i++) {
			graph[i][i]=1;
		}
		
		floydWarshall();
		
		
		while (n-->0) {
			String[] words = in.readLine().split(" ");
			
			boolean ok = words[0].length() == words[1].length();
			
			if (ok) {
				for (int i = 0; i < words[0].length()&&ok; i++) {
					
					if (graph[words[0].charAt(i)-a][words[1].charAt(i)-a]!=1) {
						ok = false;
					}
				}
			}
			
			out.write(ok ? "yes" : "no");
			out.write("\n");
		}
				
	
		out.close();
		in.close();
	
	}



	private static void floydWarshall() {
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				for (int k = 0; k < graph.length; k++) {
					graph[j][k] |= graph[j][i] & graph[i][k];
				}
			}
		}
		
	}

}
