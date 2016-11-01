import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DigitCounting {
	
	
	static int[] apariciones;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int veces = Integer.parseInt(in.readLine());
		
		

		while (veces-->0) {
			
			int N = Integer.parseInt(in.readLine());
			apariciones = new int[10];
			
//			System.out.println(N);
			
			for (int i = 1; i <= N; i++) {
				
				String sb = i+"";
				
				for (int j = 0; j < sb.length(); j++) {
					int a = Integer.parseInt(sb.charAt(j)+"");
//					System.out.println(a);
					apariciones[a]++;
				}
				
				
			}
			
			out.write(imprimir());
			
		}
		
		out.close();
		in.close();
	}
	
	
	static String imprimir() {
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < apariciones.length; i++) {
				res.append(apariciones[i]);
				if (i==apariciones.length-1) 
						res.append("\n");
				else 
					res.append(" ");
				
		}
		
		return res.toString();
	}

}
