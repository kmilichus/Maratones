import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;



public class incognito {
	
	
		public static int [][] rutas;
		
		public static void main(String[] args) throws Exception { 
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 
			
			
			int casos = Integer.parseInt(in.readLine());
			int posibilidades;
			
			
			
			while (casos >0) {
				
				posibilidades = 1;
				HashMap<String, Integer> ropa = new HashMap<String, Integer>();
				
				int veces = Integer.parseInt(in.readLine());
				
				for (int i = 0; i < veces; i++) {
					
					StringTokenizer stk = new StringTokenizer(in.readLine());
					String valor = stk.nextToken();
					String llave = stk.nextToken();
					if (ropa.containsKey(llave)) {
						
						int x = ropa.get(llave);
						x++;
						ropa.put(llave, x);
//						System.err.println(ropa.get(llave));
					
					}else {
						ropa.put(llave, 2);
					}
				}
				
				
				
							
				if (ropa.size()>0) {
					
					Iterator it = ropa.entrySet().iterator();

					 while (it.hasNext()) {
					        Map.Entry pairs = (Map.Entry)it.next();
					        int xx = (Integer)pairs.getValue();
//					        System.err.println("caso: " + casos +" Cantidad Etiquetas "+pairs.getValue());					        
					        if (xx!=0) {					
					        	posibilidades*= xx;
							}
//					        it.remove(); 
					    }
					
				}
				
				
				
				out.write(posibilidades-1+"\n");

				casos --;
				
			}

			out.flush();
	        out.close(); 
	        in.close(); 
			
			
			
		}
		
		
		public static int binomial(int n, int m){
			int[]b = new int[n+1];
			b[0]=1;
			
			for (int i = 1; i <= n; i++) {
				b[i]=n;
				for (int j = i-1; j < 0; j--) {
					b[j]+= b[j-1];
				}
				
			}
			return b[m];
		}
		
		
		

}
