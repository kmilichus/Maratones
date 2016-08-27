import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FlowersFlourishFromFrance {

	/**
	 * Camilo Barrios
	 * Uva - 12243 - Flowers Flourish from France
	 * 
	 */


	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();

		while (!linea.equals("*")) {			
			
			linea = linea.toLowerCase();
			StringTokenizer stk = new StringTokenizer(linea);
			boolean ok = true;
			char primera = ' ';
			primera = stk.nextToken().charAt(0);

			while (stk.hasMoreTokens() && ok) {
				if (primera != stk.nextToken().charAt(0)) {
					ok = false;
				}
				
			}
			
			out.write(ok?"Y\n":"N\n");
			linea = in.readLine();
		}
		in.close();
		out.close();	
	}





}