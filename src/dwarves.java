
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class dwarves {


	public static TreeMap<String,Vertice> vertices;
	static final int INF = Integer.MAX_VALUE;
	public static int totalVertices;
	public static int totalAristas;
	public static String primero;


	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


		int veces = Integer.parseInt(in.readLine());
		vertices = new TreeMap<String, Vertice>();

		String linea;
		totalVertices = 0;
		totalAristas = veces;

		while (veces-->0) {		

			linea = in.readLine();

			StringTokenizer stk = new StringTokenizer(linea);

			String enano1 = stk.nextToken();
			String relacion = stk.nextToken();
			String enano2 = stk.nextToken();


			if (primero ==null) {
				primero = enano1;
			}

			if (!vertices.containsKey(enano1)) {
				Vertice a = new Vertice(enano1, totalVertices);
				vertices.put(enano1, a);
				totalVertices++;
			}

			if (!vertices.containsKey(enano2)) {
				Vertice a = new Vertice(enano2, totalVertices);
				vertices.put(enano2, a);
				totalVertices++;
			}



			if (relacion.equals(">")){ 
				vertices.get(enano1).listaAdyacencias.add(new Arista(vertices.get(enano2), 1));
			}
			else {
				vertices.get(enano2).listaAdyacencias.add(new Arista(vertices.get(enano1), 1));
			}

		}

		out.write(BFS()?"impossible\n":"possible\n");

		out.close();
		in.close();


	}


	static class Vertice implements Comparable<Vertice> {
		public String nombre;
		public int id;
		List<Arista> listaAdyacencias = new ArrayList<Arista>();

		public Vertice(String nombre, int id) {
			this.nombre = nombre;
			this.id  =id;
		}

		@Override
		public int compareTo(Vertice o) {
			return nombre.compareTo(o.nombre);
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
		public int id;

		public Elemento(Vertice v, int distance) {
			vertice = v;
			this.distancia = distance;
		}

		public int compareTo(Elemento e) {
			return this.distancia - e.distancia;
		}

	}

	static boolean BFS() {

		boolean[] visitados = new boolean[totalVertices];

		PriorityQueue<Elemento> colaP = new PriorityQueue<Elemento>();

		colaP.add(new Elemento(vertices.get(primero), 0));


	
		while (!colaP.isEmpty()) {
			Elemento elementoActual = colaP.poll();
			Vertice verticeActual = elementoActual.vertice;

			if (!visitados[verticeActual.id]) {
				visitados[verticeActual.id] = true;

				for (int i = 0; i < verticeActual.listaAdyacencias.size(); i++) {
					Vertice verticeDestino = verticeActual.listaAdyacencias.get(i).destino;
					int peso = verticeActual.listaAdyacencias.get(i).peso;
					if (visitados[verticeDestino.id]) {
						return true;
					}
					colaP.add(new Elemento(verticeDestino, peso));	
				}
			}

		}


	return false;
}




}
