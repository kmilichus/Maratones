import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class HardwoodSpecies {

	/**
	 * Camilo Barrios
	 * Uva 10226 - Hardwood Species
	 * AC
	 */

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int veces = Integer.parseInt(in.readLine());
		in.readLine();


		while (veces>0) {

			TreeMap<String, Integer> forest = new TreeMap<String, Integer>();
			String tree = in.readLine();
			double k = 0;
			while (tree!=null && !tree.equals("")) {
				
				if (forest.containsKey(tree)) 			
					forest.put(tree, forest.get(tree)+1);
				else 
					forest.put(tree, 1);

				tree = in.readLine();
				k++;
			}

			for (String key: forest.keySet()) {
				//				String l = a.getKey()+" "+a.getValue();
				out.printf("%s %.4f\n",key,(double)(forest.get(key)/k)*100d );
			}
			veces--;
			if (veces!=0){ 
				out.write("\n");
			}
		}
		in.close();
		out.close();
	}


}