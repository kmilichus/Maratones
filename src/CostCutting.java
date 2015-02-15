import java.util.Scanner;

public class CostCutting{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int veces = in.nextInt();
		for (int i = 1; i <= veces; i++) {
			int[] salarios = new int[3];
			int max = 0;
			int min = 10001;
			int alto = 0;
			int bajo = 0;
			int medio = 0;
			for (int j = 0; j < salarios.length; j++) {
				salarios[j] = in.nextInt();
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