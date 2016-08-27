import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DarkRoads {

	public static Vertice[] vertices;
	static final int INF = Integer.MAX_VALUE;
	public static int totalVertices;


	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea = in.readLine();


		while (!linea.equals("0 0")) {

			StringTokenizer stk = new StringTokenizer(linea);

			totalVertices = Integer.parseInt(stk.nextToken());
			int totalAristas = Integer.parseInt(stk.nextToken());

			vertices = new Vertice[totalVertices];

			for (int i = 0; i < totalVertices; i++) 
				vertices[i]= new Vertice(i);

			int precioTotal = 0;

			for (int i = 0; i < totalAristas; i++) {
				linea = in.readLine();
				stk = new StringTokenizer(linea);

				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int precio = Integer.parseInt(stk.nextToken());

				precioTotal+= precio;

				vertices[a].listaAdyacencias.add(new Arista(vertices[b], precio));
				vertices[b].listaAdyacencias.add(new Arista(vertices[a], precio));

			}

			out.write(precioTotal - MST(0) +"\n");

			linea = in.readLine();
		}

		out.close();
		in.close();


	}


	static class Vertice {
		public int id;
		List<Arista> listaAdyacencias = new ArrayList<Arista>();

		public Vertice(int id) {
			this.id = id;
		}
	}

	static class Arista {
		Vertice destino;
		int peso;

		public Arista(Vertice destino, int peso) {
			this.destino = destino;
			this.peso = peso;
		}
	}

	static class Elemento implements Comparable<Elemento> {

		public Vertice vertice;
		public int distancia;

		public Elemento(Vertice v, int distance) {
			vertice = v;
			this.distancia = distance;
		}

		public int compareTo(Elemento e) {
			return this.distancia - e.distancia;
		}

	}

	static int MST(int inicio) {

		boolean[] visitados = new boolean[totalVertices];
		int[] distancias = new int[totalVertices];
		int[] padres = new int[totalVertices];
	

		Arrays.fill(distancias, INF);
		Arrays.fill(padres, -1);

		PriorityQueue<Elemento> colaP = new PriorityQueue<Elemento>();

		distancias[inicio] = 0;
		colaP.add(new Elemento(vertices[inicio], 0));

		while (!colaP.isEmpty()) {
			Elemento elementoActual = colaP.poll();
			Vertice verticeActual = elementoActual.vertice;

			if (!visitados[verticeActual.id]) {
				visitados[verticeActual.id] = true;

				for (int i = 0; i < verticeActual.listaAdyacencias.size(); i++) {
					Vertice verticeDestino = verticeActual.listaAdyacencias.get(i).destino;
					int peso = verticeActual.listaAdyacencias.get(i).peso;

					if (!visitados[verticeDestino.id] && peso < distancias[verticeDestino.id]) {
						distancias[verticeDestino.id] = peso;
						padres[verticeDestino.id] = verticeActual.id;
						colaP.add(new Elemento(verticeDestino, peso));
					}
				}
			}
		}

		int pesoMST = 0;
		
		for (int i = 0; i < totalVertices; ++i)
			pesoMST += distancias[i];

		return pesoMST;
	}


}
