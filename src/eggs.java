import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class eggs {

	public static int[]primos;


	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea = in.readLine();
		calcularprimos(1000001);

		while (linea!=null) {
			int veces = 0;
			int lanzar = 0;
			int eggs = Integer.parseInt(linea);

			while (eggs!=0) {

				lanzar = primos[eggs];
				veces++;
				eggs-= lanzar;
			}

			out.write(veces+"\n");
			linea = in.readLine();
		}

		out.flush();
		out.close();
		in.close();




	}


	public static void calcularprimos(int limit){
		primos = new int[limit];
		primos[0]=1;
		primos[1]=1;

		for (int i = 2; i < limit; i++){
			if (primos[i]==0) {	
				for (int j = i; j < limit; j += i){
					primos[j]=i;
				}
			}
		}

	} 



}
