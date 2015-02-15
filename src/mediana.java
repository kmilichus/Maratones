import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class mediana {


	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		//ArrayList numeros = new ArrayList<Integer>();;
		double mediana;
		int uno,dos;

		while (N!=0) {
			mediana = 0;
			String[] numeros = new String[N];
			numeros = in.readLine().split(" ");
			int[]ordenados = new int[N];			
			for (int i = 0; i < ordenados.length; i++) {
				ordenados[i] = Integer.parseInt(numeros[i]);
			}
			Arrays.sort(ordenados);
			
			//probando
			
//			for (int i = 0; i < ordenados.length; i++) {
//				System.out.print(ordenados[i]+" - ");
//			}
//			System.out.println();
//			
			if(N%2 == 0){
				uno =ordenados[(int)N/2];
				dos =ordenados[((int)N/2)-1];
				mediana = (uno+dos)/2;
			}else{
				mediana = (ordenados[(int)N/2]);
			}

			System.out.printf("%.1f\n",mediana);
			N=	Integer.parseInt(in.readLine());	
		}

		// out.flush();
		// out.close();
		in.close();





	}

}
