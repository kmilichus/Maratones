import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RequestForProposal {

	public static ArrayList<String> rf;
	public static String winningP;
	public static int winningCompilance;
	public static double winningPrice;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String linea = in.readLine();
		
		
		int veces = 1;
		while (!linea.equals("0 0")) {
			
			if (veces!=1) {
				System.out.println();
			}
			
			rf = new ArrayList<String>();
			winningP="";
			
			
			StringTokenizer stk = new StringTokenizer(linea);
			double requirements = Double.parseDouble(stk.nextToken());
			int proposals = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < requirements; i++) {
				rf.add(in.readLine());
				
			}
			
			
			for (int i = 0; i < proposals; i++) {
				
				String nombre = in.readLine();
				
				stk = new StringTokenizer(in.readLine());
				double precio = Double.parseDouble(stk.nextToken());
				int cantidadRequerimientos = Integer.parseInt(stk.nextToken());
				
				int cumplidos = cantidadRequerimientos;
				
				for (int j = 0; j < cantidadRequerimientos; j++) {
					
					linea = in.readLine();
//					if (rf.contains(linea)) {
//						cumplidos++;
//					}
				}
				
//				double compliance = cumplidos/requirements;
				
				
				if (i==0) {
					winningP = nombre;
					winningCompilance = cumplidos;
					winningPrice = precio;
					
				}else if(winningCompilance< cumplidos) {
					winningP = nombre;
					winningCompilance = cumplidos;
					winningPrice = precio;
//					System.out.println(cumplidos);
					
				}else if (winningCompilance == cumplidos && winningPrice> precio) {
					winningP = nombre;
					winningCompilance = cumplidos;
					winningPrice = precio;
					
				}
				
				
			}
			
			
//			out.write("RFP #1\n");
//			out.write(winningP+"\n");
			
			System.out.println("RFP #"+veces);
			System.out.println(winningP);
			veces++;
			
			linea = in.readLine();
		}
		
		
//		out.flush();
//		out.close();
		in.close();
	}

}
