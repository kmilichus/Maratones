import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class BrickGame {


	public static void main(String[] args) throws Exception {

		Scanner lector = new Scanner(System.in);
		int veces;
		int casos = lector.nextInt();
		int jugadores = 0;
		StringBuffer sb = new StringBuffer("");
		String hola;
		for (int i = 1; i <= casos; i++) {
			jugadores = lector.nextInt();

			veces = (jugadores/2)+1;

			while(veces>0){
				jugadores = lector.nextInt();
				veces--;
			}

			hola = lector.nextLine();

			sb.append("Case "+i+": "+jugadores+"\n");

		}

		System.out.print(sb);

	}

}
