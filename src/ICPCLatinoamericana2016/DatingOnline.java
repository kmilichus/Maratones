import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;

public class DatingOnline {
	
	
	static Double C;



	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String linea = in.readLine();
		
		int actividades = Integer.parseInt(linea);
		C= 360.0/actividades;
		
		LinkedList<Double> puntos = new LinkedList<Double>();
		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		while (stk.hasMoreTokens()) 
			puntos.add(Double.parseDouble(stk.nextToken()));
			
		
		Collections.sort(puntos);
		
		Double anterior = puntos.poll();	
		Double actualDer =puntos.poll();
		Double actualIzq =puntos.poll();

		Double respuesta = calcularArea(anterior, actualDer);
		respuesta += calcularArea(anterior, actualIzq);
				
		while (!puntos.isEmpty()) {

			anterior = actualDer;
			actualDer = puntos.poll();
			respuesta += calcularArea(anterior, actualDer);
			
			if (!puntos.isEmpty()) {		
				anterior = actualIzq;
				actualIzq = puntos.poll();
				respuesta += calcularArea(anterior, actualIzq);	
			}
	
		}
		
		// ultimo
		respuesta+= calcularArea(actualIzq, actualDer);
		
					
		out.printf(new Locale("en"),"%.3f\n",respuesta);
		
		in.close();
		out.close();
	}

	private static Double calcularArea(Double primero, Double actual) {
		
		return ((primero*actual)/2.0)*Math.sin(Math.toRadians(C));
	}



}