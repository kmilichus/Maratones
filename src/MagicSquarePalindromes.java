
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MagicSquarePalindromes {


	static int tama�o;

	public static void main(String args[]) throws Exception {


		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		boolean magic;
		String line;
		line = lector.readLine();
		int casos = Integer.parseInt(line);

		for (int i = 1; i <= casos; i++) {
			tama�o= 0;
			line = lector.readLine();
			if (line != null){
				line = removeChar(line);    		
				magic = false;
				if (line != null){
					if(cuadrado(line)){
						if(palindromo(line))
							magic = true;
					}
				

					System.out.println("Case #"+i+":");
					System.out.println(magic?" "+tama�o:"No magic :(");
				}
			}
		}
		lector.close();
	}

	private static String removeChar(String line) {
		String linea = "";
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i)!= ' ' && line.charAt(i)!= '.' && line.charAt(i)!= ',' && line.charAt(i)!= '?' && line.charAt(i)!= '!' && line.charAt(i)!= '(' && line.charAt(i)!= ')' ){
				linea += line.charAt(i);
			}
		}
		return linea.toLowerCase();

	}


	private static boolean cuadrado (String palabra){
		tama�o = (int)Math.floor(Math.sqrt(palabra.length()));
		return tama�o*tama�o == palabra.length();
	}

	private static boolean palindromo(String linea) {
		boolean flag = true;
		for (int i = 0, j = linea.length() - 1; i < linea.length() / 2; i++, j--) {
			if (linea.charAt(i) != linea.charAt(j)) {
				flag=false;;
			}
		}
		return flag;
	}
}



