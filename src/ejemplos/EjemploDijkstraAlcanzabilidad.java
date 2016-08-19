
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class EjemploDijkstraAlcanzabilidad{

	private static int m[][]; // Matriz de Adyacencias
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int numGames = Integer.valueOf(in.readLine());
		StringBuilder respuesta1 = new StringBuilder();
		StringTokenizer tokens;
		LinkedList prohibidas;
		int numProhibidas, lugares, rutas, inicio, fin;
		String clave = "";

		for (int i = 0; i < numGames; i++) {

			numProhibidas = Integer.valueOf(in.readLine());
			prohibidas = new LinkedList<String>();

			for (int j = 0; j < numProhibidas; j++) {
				prohibidas.addFirst(in.readLine());
			}

			tokens = new StringTokenizer(in.readLine());
			lugares = Integer.valueOf(tokens.nextToken());
			rutas = Integer.valueOf(tokens.nextToken());

			m = new int[lugares][lugares];
			inicializarMatriz();
			for (int j = 0; j < rutas; j++) {
				tokens = new StringTokenizer(in.readLine());
				inicio = Integer.valueOf(tokens.nextToken());
				fin = Integer.valueOf(tokens.nextToken());
				clave = tokens.nextToken();

				if (!prohibidas.contains(clave)) {
					m[inicio][fin] = 50;
					//System.out.println(inicio +" "+fin+" caso num "+(1+i) );
				}
			}



			if (dijkstraAlcanzabilidad(0)) {
				respuesta1.append("1\n");
			} else {
				respuesta1.append("0\n");
			}

		}

		out.write(respuesta1.toString());
		out.flush();
		out.close();
		in.close();

	}

	//Este es una variante del algoritmo de Dijkstra
	//Solo encuentra si es posible llegar a un nodo a partir de uno.
	//Cuando Lo entiendas lo generalizamo más
	//Camilo 
	public static boolean dijkstraAlcanzabilidad(int inicio) {
		boolean llego = false;
		// Elementos funcionales
		int distancia[] = new int[m.length];                    // La distancia que toma llegar a desde inicio hasta el vertice i
		int padre[] = new int[m.length];                        // El mejor camino para llegar un nodo i es desde padre[i]
		Pareja actual;                                              // [Peso, Vertice al que pertenece]
		PriorityQueue<Pareja> cola = new PriorityQueue<Pareja>();   // Cola de prioridad por peso para guardar las parejas a las que tengo conexion

		for (int i = 0; i < m.length; i++) {
			distancia[i] = Integer.MAX_VALUE;                       // Todas las distancias inician siendo infinitas
			padre[i] = -1;                                          // Todos los padres se identifican como -1 para decir que no se sabe aun la ruta mas corta
		}
		distancia[inicio] = 0;                                      // La distancia par el inicio es 0 por definicion
		padre[inicio] = inicio;                                     // El padre de inicio es el mismo por definicion

		cola.add(new Pareja(0, inicio));                            // Se agrega la primera pareja (peso, vertice) como el inicio con peso 0 para empezar a trabajar
		while (!cola.isEmpty()) {                                     // Mientras que la cola tenga parejas (peso, vertice) se debe seguir buscando las rutas mas cortas
			actual = cola.poll();                                   // Se saca la pareja de menor peso, ya que es una cola de prioridad por peso
			if (actual.peso == distancia[actual.vertice]) {           // Esta validacion es importante, npi
				for (int j = 0; j < m.length; j++) {                                             // Se relajan los vertices
					if (m[actual.vertice][j] != Integer.MAX_VALUE && // Aquellos a los que estoy conectado
							distancia[actual.vertice] + m[actual.vertice][j] < distancia[j]) {    // Y cuya distancia es menor a travez de mi
						distancia[j] = distancia[actual.vertice] + m[actual.vertice][j];         // Se asigna una nueva distancia
						padre[j] = actual.vertice;                                                   // Se asigna un nuevo padre
						cola.add(new Pareja(distancia[j], j));                                       // Se agrega a la cola de prioridad para ser trabajado despues
					}
				}
			}
		}

		if (distancia[distancia.length-1] != Integer.MAX_VALUE) {
			llego =true;
		}
		return llego;
	}

	//Clase para hacer las comparaciones del peso
	//Se necesita la comparación para poder relajar el vertice correctamente.
	//El peso es el factor de decision
	public static class Pareja implements Comparable {

		public int peso;
		public int vertice;

		public Pareja(int peso, int vertice) {
			this.peso = peso;
			this.vertice = vertice;
		}

		@Override
		public int compareTo(Object nueva) {
			return peso - ((Pareja) nueva).peso;
		}
	}

	static void inicializarMatriz (){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j]= Integer.MAX_VALUE;
			}
		}

	}

}

