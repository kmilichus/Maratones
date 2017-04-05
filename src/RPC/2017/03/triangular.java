import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class triangular {


	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


		int veces = Integer.parseInt(in.readLine());


		while (veces-->0) {

			long num = Long.parseLong(in.readLine());
			num--;
			String men = "";

			if (num<4) {

				if (num==0) {
					out.write("0 0\n");
				} else if (num==1) {
					out.write("-1 0\n");
				} else if (num==2) {
					out.write("0 1\n");
				}else {
					out.write("1 0\n");
				}

			}else {

				long indiceEsquinaDerecha = (long) Math.ceil(Math.sqrt(num));

				if (indiceEsquinaDerecha%2!=0) {
					indiceEsquinaDerecha++;
				}

				long indiceEsquinaIzquirda = indiceEsquinaDerecha-1;

				long indiceEsquinaDerechaAnterior = indiceEsquinaIzquirda-1;


				long ED = indiceEsquinaDerecha*indiceEsquinaDerecha;
				long EI = indiceEsquinaIzquirda*indiceEsquinaIzquirda;
				long EDA = indiceEsquinaDerechaAnterior * indiceEsquinaDerechaAnterior;
				long ARRIBA = ED - 2*(indiceEsquinaDerecha/2);


				if (num<=ED && num >= ARRIBA) {
					men = darCordenada(ARRIBA, ED, num, 2);
				}else if (num<ARRIBA && num> EI){
					men = darCordenada(EI, ARRIBA, num, 1);
				}else {
					men = darCordenada(EDA, EI, num, 0);
				}
				out.write(men+"\n");
			}



		}


		out.close();
		in.close();

	}


	private static String darCordenada(long menor, long mayor, long valor, int ubicacion){

		int[] pos = new int[2];

		switch (ubicacion) {
		case 0:
			// ENTRE EDA && EI

			pos[1]= (int) (((Math.sqrt(mayor)-1)/2)*-1); 
			pos[0]=  (int) ((Math.sqrt(mayor)*-1)+ Math.abs(mayor-valor));

			break;

		case 1:
			// ENTRE EI && ARRIBA

			//			pos[1]= (int) ((((Math.sqrt(menor)-1)/2)*-1)- ((Math.abs(menor-valor))+1)); 
			pos[1]= (int) ((((Math.sqrt(menor)-1)/2)*-1) + ((Math.abs(menor-valor)))); 
			pos[0]= (int) ((Math.sqrt(menor)*-1)+ Math.abs(menor-valor));

			break;



		case 2:
			// ENTRE ARRIBA && ED

			pos[1]= (int) (((Math.sqrt(mayor)/2l)*-1)+Math.abs(mayor-valor));
			pos[0]= (int) (Math.sqrt(mayor)-Math.abs(mayor-valor)); 

			break;

		}

		return pos[0]+" "+pos[1];
	}


}