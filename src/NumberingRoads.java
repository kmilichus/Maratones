import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NumberingRoads{

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));       

		String linea = in.readLine();
		StringTokenizer stk = new StringTokenizer(linea);
		int calles = Integer.valueOf(stk.nextToken());
		int cantidadNumeros = Integer.valueOf(stk.nextToken());      
		int i = 1;
		
		while (calles != 0 && cantidadNumeros != 0 ) {

//			if (cantidadNumeros >= calles) {
//				out.write("Case "+i+": 1\n");
//			} else {
//				if (cantidadNumeros * 26 + cantidadNumeros < calles) {
//					out.write("Case "+i+": impossible\n");
//				}
//				else {
//					int x = (calles-cantidadNumeros)/26;
//					out.write("Case "+i+": "+(x+1)+"\n");
//				}
//			}
			
			int s = (calles - 1)/cantidadNumeros;
			if (s > 26) {
				out.write("Case "+i+": impossible\n");
			} else {
				out.write("Case "+i+": "+s+"\n");
			}
			linea = in.readLine();
			stk = new StringTokenizer(linea);
			calles = Integer.valueOf(stk.nextToken());
			cantidadNumeros = Integer.valueOf(stk.nextToken());
			i++;
		}

		in.close();
		out.flush();
		out.close();
	}
}
