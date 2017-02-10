package maratones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SherlockAndPermutations {
	
	static final long primo = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


		int veces = Integer.parseInt(in.readLine());


		while (veces-->0) {
			
			long respuesta = 0;

			StringTokenizer stk = new StringTokenizer(in.readLine());
			
			long N = Long.parseLong(stk.nextToken());
			long M = Long.parseLong(stk.nextToken());

			// m-1 + n!	 / (m-1) !	n!			
			
			
			long x = factorialModulo(M-1, primo);
			long y = factorialModulo(N, primo);
			
			long numerador = factorialModulo((M-1)+N, primo);
			
			long denominador = (x*y) ;
			
			denominador%= primo;
			
			respuesta = numerador* modpow(denominador, primo-2, primo);
			
			BigInteger a = new BigInteger(denominador+"");
			BigInteger res =a.modInverse(new BigInteger(primo+""));
			
			
			out.write(res.toString()+"\n");
		}


		out.close();
		in.close();

	}

	private static long factorialModulo(long l, long primo2) {
		
		long fact = 1;
		
		
		for (int i = 1; i < l; i++) {
			fact *= i;
			fact %= primo2;
		}
		
		
		return fact;
	}
	
	 public static long modpow(long value , long power, long mod){
		    long e = 1;
		   
		    for (int i = 0; i < power; i++) {
		         e = ((e * value) % mod);
		            
		    }
		        
		        return e;
		}
	 

	
	


}
