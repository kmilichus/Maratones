import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main{

	public static void main(String[] args) throws IOException {
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		int veces  = Integer.parseInt(lector.readLine());
		
		for (int i = 1; i <= veces; i++) {
			int[] salarios = new int[3];
			
			int max = 0;
			int min = 10001;
			int alto = 0;
			int bajo = 0;
			int medio = 0;
			
			String[] salariosString = lector.readLine().split(" ");
			
			for (int j = 0; j < salarios.length; j++) {
				salarios[j] = Integer.parseInt(salariosString[j]);
				if (salarios[j] > max) {
					alto = j;
					max = salarios[j];
				}
				if (salarios[j] < min) {
					bajo = j;
					min = salarios[j];
				}
			}
			for (int j = 0; j < salarios.length; j++) {
				if (j != alto && j != bajo)
					medio = j;
			}
			System.out.println("Case "+i+": "+salarios[medio]);
		}
	}

}
