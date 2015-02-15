
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author usuario
 */
class Palindromes {

	public static void main(String args[]) throws IOException {

		char[] letras = {'A', 0, 0, 0, '3', 0, 0, 'H', 'I', 'L', 0, 'J', 'M', 0, 'O', 0, 0, 0,'2', 'T', 'U', 'V', 'W', 'X', 'Y', '5', '1', 'S', 'E', 0, 'Z', 0, 0, '8', 0};

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		boolean equal, mirror;
		String line;
		char[] palabra;


		while (true){

			line = lector.readLine();
			if(line==null || line.isEmpty())
				break;
			equal = true;
			mirror = true;
			palabra = line.toCharArray();
			for (int i = 0; i < (palabra.length / 2) + 1; i++) {
				if (equal && palabra[i] != palabra[palabra.length - i - 1]) {
					equal = false;
				}
				if (mirror) {
					if (palabra[i] > 64) {
						if (palabra[palabra.length - i - 1] != letras[palabra[i] - 65]) {
							mirror = false;
						}
					} else {
						if (palabra[palabra.length - i - 1] != letras[palabra[i] - 23]) {
							mirror = false;
						}
					}
				}
			}

			if (equal) {
				if (mirror) {
					System.out.println(line + " -- is a mirrored palindrome.");
					System.out.println();
				} else {
					System.out.println(line + " -- is a regular palindrome.");
					System.out.println();
				}
			} else {
				if (mirror) {
					System.out.println(line + " -- is a mirrored string.");
					System.out.println();
				} else {
					System.out.println(line + " -- is not a palindrome.");
					System.out.println();
				}
			}

			line = null;
		}
		lector.close();

	}


}