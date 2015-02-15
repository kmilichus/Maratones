
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MotherBear {

	public static void main(String args[]) throws Exception {


		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		boolean palindromo;
		String line;
		char[] palabra;
		line = lector.readLine();

		while (!line.equals("DONE")){
			line = removeChar(line);
			palindromo = true;
			palabra = line.toCharArray();
			for (int i = 0; i < (palabra.length / 2) + 1; i++) {
				if (palindromo && palabra[i] != palabra[palabra.length - i - 1]) {
					palindromo = false;
				}
			}
			System.out.println(palindromo?"You won't be eaten!":"Uh oh..");
			line = lector.readLine();
		}
		lector.close();
	}

	 private static String removeChar(String line) {
		String linea = "";
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i)!= ' ' && line.charAt(i)!= '.' && line.charAt(i)!= ',' && line.charAt(i)!= '?' && line.charAt(i)!= '!' ){
				linea += line.charAt(i);					
			}
		}
		return linea.toLowerCase();
	}

}



