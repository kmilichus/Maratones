import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class WordIndex {

	/**
	 * Camilo Barrios
	 * Uva 417 - Word Index
	 * 
	 */

	public static final char A = 'a';

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();
		TreeMap<String, Integer> alfabeto = generarPalabras();

		while (linea!=null) {			
			out.write(alfabeto.get(linea)==null?"0\n":alfabeto.get(linea).intValue()+"\n");
			linea = in.readLine();
		}
		in.close();
		out.close();	
	}

	private static TreeMap<String, Integer> generarPalabras() {

		TreeMap<String, Integer> a = new TreeMap<String, Integer>();

		int contador = 1;

		// tamanho 1
		for (int i = 0; i < 26; i++) {	
			char actual = (char)(A+i);
			a.put(""+actual, contador);
			contador++;
		}

		// tamanho 2
		for (int i = 0; i < 26; i++) {
			char primero = (char)(A+i);
			for (int j = i+1; j < 26; j++) {
				char segundo = (char)(A+j);
				a.put(""+primero+segundo, contador);
				contador++;
			}

		}

		// tamanho 3
		for (int i = 0; i < 26; i++) {
			char primero = (char)(A+i);
			for (int j = i+1; j < 26; j++) {
				char segundo = (char)(A+j);
				for (int k = j+1; k < 26; k++) {	
					char tercero = (char)(A+k);
					a.put(""+primero+segundo+tercero, contador);
					contador++;
				}
			}

		}

		// tamanho 4
		for (int i = 0; i < 26; i++) {
			char primero = (char)(A+i);
			for (int j = i+1; j < 26; j++) {
				char segundo = (char)(A+j);
				for (int k = j+1; k < 26; k++) {	
					char tercero = (char)(A+k);
					for (int l = k+1; l < 26; l++) {
						char cuarto = (char)(A+l);
						a.put(""+primero+segundo+tercero+cuarto, contador);
						contador++;
					}
				}
			}			
		}

		// tamanho 5
		for (int i = 0; i < 26; i++) {
			char primero = (char)(A+i);
			for (int j = i+1; j < 26; j++) {
				char segundo = (char)(A+j);
				for (int k = j+1; k < 26; k++) {	
					char tercero = (char)(A+k);
					for (int l = k+1; l < 26; l++) {
						char cuarto = (char)(A+l);
						for (int m = l+1; m < 26; m++) {
							char quinto = (char)(A+m);
							a.put(""+primero+segundo+tercero+cuarto+quinto, contador);
							contador++;
						}
					}
				}
			}			
		}




		return a;
	}






}