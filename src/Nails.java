
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Nails {
	
	
	static  ArrayList<Punto> puntos;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int veces = Integer.parseInt(in.readLine());
		DecimalFormat df = new DecimalFormat("0.0000");
		
		

		while (veces-->0) {
			
			puntos = new ArrayList<Punto>();
			StringTokenizer stk = new StringTokenizer(in.readLine());
			
			double longitud = Double.parseDouble(stk.nextToken());
			
			int cantidad = Integer.parseInt(stk.nextToken());
			
			while (cantidad-->0) {
				
				stk = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(stk.nextToken());
				double y= Double.parseDouble(stk.nextToken());
				
				puntos.add(new Punto(x,y));
			}		
			
			if(veces!=1)
				in.readLine();
			
			double distancia = 0;
			
			Collections.sort(puntos);
			
			System.out.println(Arrays.toString(puntos.toArray()));
			
			for (int i = 0; i < puntos.size()-1; i++) {
				distancia += distanciaEuclidiana(puntos.get(i), puntos.get(i+1));
			}
			
			distancia+= distanciaEuclidiana(puntos.get(0), puntos.get(puntos.size()-1));
			
			double respuesta = longitud>distancia?longitud:distancia;
			
			out.write(df.format(respuesta)+"\n");
		}
		
		out.close();
		in.close();
	}
	
	

	static double distanciaEuclidiana(Punto puntoA, Punto puntoB){
		return Math.sqrt(Math.pow(puntoB.x-puntoA.x, 2.0)+Math.pow(puntoB.y-puntoA.y, 2.0));
	}
	
	
	static class Punto implements Comparable<Punto>{
	
		Double x;
		Double y;
		
		
		public Punto(double x, double y){
			this.x = x;
			this.y = y;
		}

		
		public int compareTo(Punto p) {
			
			int val = x.compareTo(p.x);

			if (val==0) 
				return y.compareTo(p.y);
				
			
			return val;
		}
		
		@Override
		public String toString() {
			return "["+x+" "+y+"]";
		}
		
	
		
	}



}
