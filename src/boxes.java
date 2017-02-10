package maratones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boxes {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int veces = Integer.parseInt(in.readLine());
		
		
		while (veces-->0) {
			
		StringTokenizer stk = new StringTokenizer(in.readLine());	
		long friends  =	Long.parseLong(stk.nextToken());
		long boxes  =	Long.parseLong(stk.nextToken());
			
		long respuesta = 0;
		
		for (long i = 0; i < boxes; i++) {
			
			stk = new StringTokenizer(in.readLine());
			stk.nextToken();
			
			long acumulado = Long.parseLong(stk.nextToken());
			
			while (stk.hasMoreTokens()) {
				acumulado *= Long.parseLong(stk.nextToken());
				acumulado %=friends;
			}
			
			acumulado+= respuesta;
			respuesta = acumulado%friends;
			
		}
		
		
		out.write(respuesta+"\n");
		
		
		
		}
		
		
		out.close();
		in.close();
		
	}

}
