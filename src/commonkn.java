

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class commonkn {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
		
		BigInteger dos = new BigInteger("2");
		
		BigInteger cuatro = new BigInteger("4");
		
		BigInteger ans = dos.pow(n).multiply(cuatro.pow(n));
		
		
		out.write(ans.toString()+"\n");
	
		out.close();
		in.close();

	}
	



}
