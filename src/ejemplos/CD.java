import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CD {

	/**
	 * Camilo Barrios
	 * Uva 11849 - CD
	 * AC
	 */

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();


		while (!linea.equals("0 0")) {

			StringTokenizer stk = new StringTokenizer(linea);
			int jack = Integer.parseInt(stk.nextToken());
			int jill = Integer.parseInt(stk.nextToken());
			
			HashSet<String> CD = new HashSet<String>();
	
			while (jack-->0) 
				CD.add(in.readLine().trim());
			
			int repetidos = 0;
			
			while (jill-->0) {
				if (!CD.add(in.readLine().trim()))
					repetidos++;
			}
			
			out.write(repetidos+"\n");
			linea = in.readLine();
		}
		in.close();
		out.close();
	}


}