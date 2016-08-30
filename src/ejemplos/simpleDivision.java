import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class simpleDivision {

	/**
	 * Camilo Barrios
	 * Uva 417 - Simple Division
	 * 
	 */

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();

		while (!linea.equals("0")) {			
			
			StringTokenizer stk = new StringTokenizer(linea);
			
			long[] entrada = new long[stk.countTokens() -1];
			long menor = Integer.MAX_VALUE;
			
			for (int i = 0; i < entrada.length; i++) {
				entrada[i] = Integer.parseInt(stk.nextToken());
				menor = Long.min(menor, entrada[i]);
			}
			
			for (int i = 0; i < entrada.length; i++) {
				entrada[i] -= menor;
			}
			
//			out.write("Menor: "+menor+"\n");
//			out.write("Arreglo de Diferencias: "+Arrays.toString(entrada)+"\n");
			
			long MCD = 0;
			
			for (int i = 0; i < entrada.length; i++) {
				MCD = GCD(MCD, entrada[i]);
			}
			
			out.write(MCD+"\n");
			
			linea = in.readLine();	
		}
		in.close();
		out.close();	
	}

	static long GCD(long a, long b) {
		return b == 0 ? a : GCD(b, a % b);
	}





}