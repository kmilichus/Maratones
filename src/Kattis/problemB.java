import java.io.*;
import java.util.*;

public class problemB {

	private static int m[][];
	private static HashMap<Integer, Integer>[] g;

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


			g= new HashMap[n];

			for (int i = 0; i < n; i++) 
				g[i] = new HashMap<Integer, Integer>();


			for (int i = 0; i < e; i++) {
				stk = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
				g[u].put(v, w);
			}

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
		int distancia[] = new int[g.length];                    
		int padre[] = new int[g.length]; 
		boolean visited[] = new boolean[g.length];
		boolean visitedAll;
		Pareja actual;                                              
		PriorityQueue<Pareja> cola = new PriorityQueue<Pareja>();   

		for (int i = 0; i < g.length; i++) {
			distancia[i] = inf;                       
			padre[i] = -1;    
			visited[i] = false;
		}

		distancia[inicio] = 0;                                      
		padre[inicio] = inicio;                                    

		cola.add(new Pareja(0, inicio)); 


		do {	
			while (!cola.isEmpty()) {                                    
				actual = cola.poll();   
				visited[actual.vertice]=true;
				if (actual.peso == distancia[actual.vertice]) {     

					for (Map.Entry<Integer, Integer> entry : g[actual.vertice].entrySet()) {
						//					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
						if (distancia[actual.vertice] + entry.getValue() < distancia[entry.getKey()]) {   
							distancia[entry.getKey()] = distancia[actual.vertice] +entry.getValue();         
							padre[entry.getKey()] = actual.vertice;                                                   
							cola.add(new Pareja(distancia[entry.getKey()], entry.getKey()));                                       
						} 			    
					}
				}
			}
			
			visitedAll = true;
			
			for (int i = 0; i < visited.length && visitedAll; i++) {
				if (!visited[i]) {
					visitedAll = false;
					cola.add(new Pareja(0, i));
				}
			}
			
			
		} while (!visitedAll);


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