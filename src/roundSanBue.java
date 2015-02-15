
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class roundSanBue {



	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter out = new BufferedWriter( new OutputStreamWriter(System.out));

		StringTokenizer stk;
		stk  = new StringTokenizer(in.readLine());
		int jugadores = Integer.parseInt(stk.nextToken());

		while (jugadores!=0) {
			int turnos = Integer.parseInt(stk.nextToken());


			ArrayList<Integer> lista = new ArrayList<Integer>();
			int xBorrar = 0;

			int cociente = (int) Math.floor(turnos/jugadores);
			int resudio = turnos%jugadores;
//			System.out.println("Cociente: "+cociente +" Residuio: "+ resudio );

			for (int i = 0; i < jugadores; i++) {
				if (i<resudio) {
					lista.add(cociente+1);
				}else {
					lista.add(cociente);
				}
			}
//			imprimirLista(lista);


			int contador = 1;
			salida:
				while (true) {
//					System.out.println("Intento #"+contador);
					xBorrar =listo(lista);
//					System.err.print("contador: "+contador+ " Tamaño: "+lista.size()+ " Acumulado: "+lista.get(0));
//					System.out.println(" El que se borra:"+xBorrar);
					if (xBorrar>=0) {
						lista.remove(xBorrar);

					}else {
						//imprimo respuesta

						out.write(lista.size()-1+" "+lista.get(0)+"\n");
						break salida;
					}
//					imprimirLista(lista);
					cociente = turnos/lista.size();
					resudio = turnos%lista.size();
//					System.out.println("Cociente: "+cociente +" Residuio: "+ resudio );
					boolean sumando = true;
//					imprimirLista(lista);


					for (int i = 0; i < lista.size(); i++) {
						if (i>=xBorrar && sumando) {
							int x = lista.get(i)+cociente+1;
							lista.set(i, x);
							resudio--;
							if (resudio<=0) {
								sumando =false;
							}
						}else {
							int x = lista.get(i)+cociente;
							lista.set(i, x);			
						}
					}
//					imprimirLista(lista);
//					System.out.println("Resudio : "+resudio );
					if (sumando) {
						for (int i = 0; i <lista.size() && resudio>0 ; i++) {
							int x = lista.get(i)+1;
							lista.set(i, x);
							resudio--;
						}
					}
					
//					imprimirLista(lista);
					contador++;


				}



			stk  = new StringTokenizer(in.readLine());
			jugadores = Integer.parseInt(stk.nextToken());
		}

		out.flush();
		out.close();
		in.close();

	}


	static int listo(ArrayList<Integer>num){
		int listo = -1;
		boolean salir = false;
		for (int i = 1; i < num.size() && !salir; i++) {
			if (num.get(i-1)!=num.get(i)) {
				listo = i-1;
				salir =true;
			}
		}
		return listo;
	}

	static void imprimirLista(ArrayList<Integer>num){

		for (int i = 0; i < num.size(); i++) {
			System.out.print(num.get(i));
		}
		System.out.println();
	}



}
