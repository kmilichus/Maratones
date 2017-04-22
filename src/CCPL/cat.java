import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cat {

	static int nodes;
	static int catStart;
	static int mouseStart;


	static ArrayList<Integer>[] catDoors;
	static ArrayList<Integer>[] mouseDoors;

	static boolean catVisided[];
	static boolean mouseVisided[];

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader (System.in) );
		BufferedWriter out = new BufferedWriter (new OutputStreamWriter(System.out));


		int T = Integer.parseInt(in.readLine());
//		in.readLine();


		while (T-->0) {


			StringTokenizer stk = new StringTokenizer(in.readLine());

			nodes=Integer.parseInt(stk.nextToken());
			catStart=Integer.parseInt(stk.nextToken());
			mouseStart=Integer.parseInt(stk.nextToken());
			
			catStart--;
			mouseStart--;

			init();


			String line = in.readLine();

			while (!line.equals("-1 -1")) {

				stk = new StringTokenizer(line);
				//gato	
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				a--;
				b--;
				catDoors[a].add(b);
				line = in.readLine();
			}


			line = in.readLine();

			while (!line.equals("")) {

				stk = new StringTokenizer(line);
				//raton
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				a--;
				b--;
				mouseDoors[a].add(b);
				line = in.readLine();
			}


	        walkingCat(catStart);

	        boolean possible = false;
	        
	        for (int i = 0; i < mouseDoors[mouseStart].size(); ++i){
	            if (!mouseVisided[mouseDoors[mouseStart].get(i)])
	                possible |= CanMakeItHome(mouseDoors[mouseStart].get(i));
	        }

	        
	        mouseVisided[mouseStart] = true;
	        
	        boolean overlap = false;
	        
	        for (int i = 0; i < nodes; ++i)
	            if (mouseVisided[i] && catVisided[i])
	                overlap = true;
	        
	       
	        StringBuilder sb = new StringBuilder();
	        
	        sb.append((overlap ? 'Y' : 'N')+" ");
	        sb.append((possible ? 'Y' : 'N')+"\n");

	        out.write(sb.toString());
		}

		out.close();
		in.close();

	}

	private static boolean CanMakeItHome(int pos) {
		
			mouseVisided[pos] = true;
		    if (catVisided[pos])
		        return false;
		    
		    if (pos == mouseStart)
		        return true;
		    
		    boolean canMakeIt = false;
		    for (int i = 0; i < mouseDoors[pos].size(); i++)
		    {
		        if (!mouseVisided[mouseDoors[pos].get(i)])
		            canMakeIt |= CanMakeItHome(mouseDoors[pos].get(i));
		    }
		    
		    return canMakeIt;

	}

	private static void walkingCat(int pos) {
		
		catVisided[pos] = true;
	    
	    for (int i = 0; i < catDoors[pos].size(); ++i)
	    {
	        if (!catVisided[catDoors[pos].get(i)])
	        	walkingCat(catDoors[pos].get(i));
	    }
		
	}

	private static void init() {


		catDoors = new ArrayList[nodes];
		mouseDoors = new ArrayList[nodes];
		catVisided = new boolean[nodes];
		mouseVisided = new boolean[nodes];

		for (int i = 0; i < nodes; i++) {
			catDoors[i]= new ArrayList<Integer>();
			mouseDoors[i]= new ArrayList<Integer>();
		}

	}

}
