
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class round {



	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter out = new BufferedWriter( new OutputStreamWriter(System.out));



		StringTokenizer stk;
		stk  = new StringTokenizer(in.readLine());
		int jugadores = Integer.parseInt(stk.nextToken());

		while (jugadores!=0) {
			int turnos = Integer.parseInt(stk.nextToken());

			int[] valores = new int[jugadores];
			boolean[] tachados = new boolean[jugadores];
			int marca =0;

			salida:
				while (true){


					int agregar = turnos;

					for (int i = marca; agregar>0; i++) {
						int pos = i%jugadores;
						if (!tachados[pos]) {
							valores[pos]+=1;
							agregar--;
						}

					}

					marca=listo(valores, tachados);
					if (marca>=0) {
						tachados[marca]=true;
					}else {
						out.write(imprimirFinal(valores, tachados));
						break salida;
					}
				}

			stk  = new StringTokenizer(in.readLine());
			jugadores = Integer.parseInt(stk.nextToken());	
		}

		out.flush();
		out.close();
		in.close();


	}

	static String imprimirFinal(int[] valores, boolean[] tachados) {
		int numero = -1;
		int cantidad = 0;
		for (int i = 0; i < tachados.length; i++) {

			if (!tachados[i]) {
				cantidad++;
				if (numero<0) {
					numero =valores[i];
				}
			}	 
		}
		return cantidad-1+" "+numero+"\n";
	}

	static int listo(int[] valores, boolean[] tachados){
		int listo = -1;
		boolean salir = false;
		boolean eligioValor = false;
		int valor = -1;

		for (int i = 0; i < valores.length && !salir; i++) {

			if (!tachados[i]) {
				if (!eligioValor) {
					valor = valores[i];	
					eligioValor=true;

				}else {
					if (valor != valores[i]) {
						listo =i-1;
						salir = true;
					}
				}
			}

		}
		return listo;
	}

	//		static void imprimirLista(int[] num){
	//	
	//			for (int i = 0; i < num.length; i++) {
	//				System.err.print(num[i]+"-");
	//			}
	//			System.err.println();
	//		}

}
