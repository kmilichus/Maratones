import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bicoloring {
	
	/**
	 * Camilo Barrios
	 * Uva 10004 - Bicoloring
	 * AC
	 */

	private static final int VACIO = 0;
	private static final int ROJO = 10;
	private static final int NEGRO = 100;

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();

		while (!linea.equals("0")) {

			int nodos = Integer.parseInt(linea.trim());
			int aristas= Integer.parseInt(in.readLine());

			int[][] grafo = new int[nodos][nodos];
			int[] visitados = new int[nodos];


			for (int i = 0; i < aristas; i++) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());

				grafo[a][b] = 1;
				grafo[b][a] = 1;
			}



			out.write(bfs(grafo, visitados)?"BICOLORABLE.\n":"NOT BICOLORABLE.\n");
			linea = in.readLine();
		}
		in.close();
		out.close();
	}



	private static boolean bfs(int[][] grafo, int[] visitados) {
		
		Queue<Integer> cola = new LinkedList<Integer>();
		cola.add(0);

		while (!cola.isEmpty()) {
			int actual = cola.poll().intValue();

			if (visitados[actual] == VACIO) {
				visitados[actual] = ROJO;
			}

			int colorActual = visitados[actual];
			int colorContrario = (colorActual == ROJO) ? NEGRO : ROJO;

			for (int i = 0; i < grafo[actual].length; i++) {
				if (grafo[actual][i] == 1) {
					if (visitados[i] == colorActual) {
						return false;
					} else if (visitados[i] == VACIO) {
						visitados[i] = colorContrario;
						cola.add(i);
					}
				}
			}
		}

		return true;
	}

}