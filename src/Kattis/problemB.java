import java.io.*;
import java.util.*;

public class problemB {



	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));


		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());
		int s = Integer.parseInt(stk.nextToken());

		
		
		LinkedList grafo = new LinkedList<LinkedList<Integer>>();
		
		
		
		

		out.write("\n");



		out.close();
		in.close();


	}
	
	public static int[] dijkstraAlcanzabilidad(int n, int inicio) {
		
	
		int distancia[] = new int[n];                    
		int padre[] = new int[n];                        
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
			if (actual.peso == distancia[actual.vertice]) {           // Esta validacion es importante, no permite que se inunden los llamados a un mismo nodo por un mismo camino
				for (int j = 0; j < m.length; j++) {                              				// Se relajan los vertices ->
					if (m[actual.vertice][j] != Integer.MAX_VALUE && 					// Aquellos a los que estoy conectado ->
							distancia[actual.vertice] + m[actual.vertice][j] < distancia[j]) {    	// Y cuya distancia es menor a travez de mi !
						distancia[j] = distancia[actual.vertice] + m[actual.vertice][j];         // Se asigna una nueva distancia (La posible nueva distancia más corta)
						padre[j] = actual.vertice;                                                   // Se asigna un nuevo padre (La nueva ruta)
						cola.add(new Pareja(distancia[j], j));                                       // Se agrega a la cola de prioridad para ser trabajado despues (porque por ese camino pueden existe otra ruta más corta)
					}
				}
			}
		}
	

		return padre;
	}

	
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
	
	
	




}