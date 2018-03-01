import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class brick {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String linea=in.readLine().trim();
		long[] numeros=generar();
		while(!linea.equals("0")) {
			int number=Integer.parseInt(linea)-1;
			out.write(numeros[number]+"\n");
			linea=in.readLine().trim();
		}
		out.close();
		
		

	}
	
	static long[] generar() {
		long[] numeros=new long[50];
		numeros[0]=1;
		numeros[1]=2;
		for (int i = 2; i < numeros.length; i++) {
			numeros[i]=numeros[i-1]+numeros[i-2];
		}
		
		return numeros;
		
		
	}

}
