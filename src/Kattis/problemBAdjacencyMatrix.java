import java.io.*;
import java.util.*;

public class problemBAdjacencyMatrix {

	private static int m[][];
	static int inf = 10000;

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));


		String line = in.readLine();


		while (!line.equals("0 0 0 0")) {


			StringTokenizer stk = new StringTokenizer(line);

			int n = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int q = Integer.parseInt(stk.nextToken());
			int s = Integer.parseInt(stk.nextToken());



//			LinkedList grafo = new LinkedList<LinkedList<Integer>>();

			m= new int[n][n];

			for (int i = 0; i < n; i++) 
				Arrays.fill(m[i], inf);


			for (int i = 0; i < e; i++) {
				stk = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
				m[u][v]= w;
			}


			//TODO resolver dijkstra
			int[] distancias = dijkstra(s);

			for (int i = 0; i < q; i++) {
				int qa = Integer.parseInt(in.readLine());
				out.write(distancias[qa]== inf ? "Impossible\n" : distancias[qa]+"\n");
			}

			line = in.readLine();

			if (!line.equals("0 0 0 0")) 			
				out.write("\n");

		}


		out.close();
		in.close();


	}

	static int[] dijkstra(int inicio) {
		int distancia[] = new int[m.length];                    
		int padre[] = new int[m.length];                       
		Pareja actual;                                              
		PriorityQueue<Pareja> cola = new PriorityQueue<Pareja>();   

		for (int i = 0; i < m.length; i++) {
			distancia[i] = inf;                       
			padre[i] = -1;                                          
		}
		distancia[inicio] = 0;                                      
		padre[inicio] = inicio;                                    

		cola.add(new Pareja(0, inicio));                            
		while (!cola.isEmpty()) {                                    
			actual = cola.poll();                                   
			if (actual.peso == distancia[actual.vertice]) {           
				for (int j = 0; j < m.length; j++) {                              				
					if (m[actual.vertice][j] != inf && 					
							distancia[actual.vertice] + m[actual.vertice][j] < distancia[j]) {    	
						distancia[j] = distancia[actual.vertice] + m[actual.vertice][j];         
						padre[j] = actual.vertice;                                                   
						cola.add(new Pareja(distancia[j], j));                                       
					}
				}
			}
		}


		return distancia;
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