package maraton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class acis {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String linea = in.readLine();
		
		while (!linea.equals("*")) {
			
			DecimalFormat df = new DecimalFormat("0.000");
			
			int cantidadPuntos = Integer.parseInt(linea);
		    double[] centro = new double[2];			
			
		    StringTokenizer stk = new StringTokenizer(in.readLine());
		    centro[0]= Double.parseDouble(stk.nextToken());
		    centro[1]= Double.parseDouble(stk.nextToken());
		    
		    double[][] vertices = new double[cantidadPuntos][2];	
		    
		    for (int i = 0; i < cantidadPuntos; i++) {
		    	stk = new StringTokenizer(in.readLine());
		    	vertices[i][0]= Double.parseDouble(stk.nextToken());
		    	vertices[i][1]= Double.parseDouble(stk.nextToken());
			}
		    
		    // encuentro la disntacia minima
		    
		    double menor = Double.MAX_VALUE;
		    
		    for (int i = 0; i < cantidadPuntos; i++) {				
		    	if (i!= cantidadPuntos -1) {					
		    		menor = Math.min(distanciaLineaAPunto(vertices[i], vertices[i+1], centro, true),menor);
				}else {
		    		menor = Math.min(distanciaLineaAPunto(vertices[i], vertices[0], centro, true),menor);
				}
			}
		    
		    
		    out.write(df.format(menor)+"\n");
		    
			linea = in.readLine();
		}
		
		
		out.close();
		in.close();
	}
	// producto punto de AB . BC
	static double productoPunto(double[] A, double[] B, double[] C){
	    double[] AB = new double[2];
	    double[] BC = new double[2];
	    AB[0] = B[0] - A[0];
	    AB[1] = B[1] - A[1];
	    BC[0] = C[0] - B[0];
	    BC[1] = C[1] - B[1];
	    double punto = AB[0] * BC[0] + AB[1] * BC[1];

	    return punto;
	}

	//Halla el producto cruz de AB x AC
	static double productoCruz(double[] A, double[] B, double[] C){
	    double[] AB = new double[2];
	    double[] AC = new double[2];
	    AB[0] = B[0] - A[0];
	    AB[1] = B[1] - A[1];
	    AC[0] = C[0] - A[0];
	    AC[1] = C[1] - A[1];
	    double cruz = AB[0] * AC[1] - AB[1] * AC[0];

	    return cruz;
	}

	//Halla la distancia de A hasta B
	static double calcularDistancia(double[] A, double[] B){
	    double d1 = A[0] - B[0];
	    double d2 = A[1] - B[1];

	    return Math.sqrt(d1 * d1 + d2 * d2);
	}

	static double distanciaLineaAPunto(double[] A, double[] B, double[] C,  boolean esSegmento){
	    double dist = productoCruz(A, B, C) / calcularDistancia(A, B);
	    if (esSegmento)
	    {
	        double punto1 = productoPunto(A, B, C);
	        if (punto1 > 0) 
	            return calcularDistancia(B, C);

	        double punto2 = productoPunto(B, A, C);
	        if (punto2 > 0) 
	            return calcularDistancia(A, C);
	    }
	    return Math.abs(dist);
	}

}
