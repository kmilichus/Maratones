import java.io.*;
import java.util.*;


 class Main {



	static List<Integer>[] g;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));



		int vertex = Integer.parseInt(in.readLine());
		vertex++;


		g = new List[vertex];        

		for (int i = 0; i < vertex; i++)

			g[i] = new ArrayList<Integer>();     


		boolean parar = false;

		while(!parar){

//		int iii = 0;
//		while(iii<4){

			Tarjan t = new Tarjan();  
			StringTokenizer stk = new StringTokenizer(in.readLine());
			


			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());

			g[u].add(v);
//			g[v].add(u);



			List<List<Integer>> SCC = t.getSCComponents(g);
			
//			System.out.println(SCC);

			parar = validar(SCC, u , v);

			String mensaje = parar?"0\n":"1\n";
			
			out.write(mensaje);
			out.flush();

//			++iii;
		}




		out.close();
		in.close();

	}



	private static boolean validar(List<List<Integer>> SCC, int u, int v) {


		for (int i = 0; i < SCC.size(); i++) {

			if(SCC.get(i).size() >=3){
				
				if (SCC.get(i).size()%2==1) {					
					return true;
				} else {
					
					int cont = 0;
					for (int j = 0; j < g[u].size(); j++) {
						
						if (SCC.get(i).contains(g[u].get(j))) {
							cont++;
						}
						
					}	
					
					if(cont>1){
						return true;
					}
					
					
//					if(SCC.get(i).contains(u)&& SCC.get(i).contains(v)){
//						return true;
//					}
					
					
				}
				
			}

		}

		return false;
	}



	static class Tarjan{



		private int V;    

		private int preCount;

		private int[] low;

		private boolean[] visited;      

		/** to store given graph **/

		private List<Integer>[] graph;

		/** to store all scc **/

		private List<List<Integer>> sccComp;

		private Stack<Integer> stack;



		public List<List<Integer>> getSCComponents(List<Integer>[] graph) {

			V = graph.length;

			this.graph = graph;

			low = new int[V];

			visited = new boolean[V];

			stack = new Stack<Integer>();

			sccComp = new ArrayList<>();



			for (int v = 0; v < V; v++)

				if (!visited[v])

					dfs(v);



			return sccComp;

		}


		public void dfs(int v) {

			low[v] = preCount++;

			visited[v] = true;

			stack.push(v);

			int min = low[v];

			for (int w : graph[v]) 

			{

				if (!visited[w])

					dfs(w);

				if (low[w] < min) 

					min = low[w];

			}

			if (min < low[v]) 

			{ 

				low[v] = min; 

				return; 

			}        

			List<Integer> component = new ArrayList<Integer>();

			int w;

			do

			{

				w = stack.pop();

				component.add(w);

				low[w] = V;                

			} while (w != v);

			sccComp.add(component);        

		}    



	}



}
