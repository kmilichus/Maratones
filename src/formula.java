
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class formula {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

//		DecimalFormat df = new DecimalFormat("0.000");
		
		
		String l = in.readLine();
		
//		while (l!=null) {
//			
			String[] arreglo = l.split(" ");
			
			
			double[] p1 = new double[2];
			double[] p2 = new double[2];
			double[] p3 = new double[2];
			
//			Punto p1 = new Punto(Double.parseDouble(arreglo[0]), Double.parseDouble(arreglo[1]));
			p1[0]=Double.parseDouble(arreglo[0]);
			p1[1]=Double.parseDouble(arreglo[1]);

			
			arreglo = in.readLine().split(" ");
			
//			Punto p2 = new Punto(Double.parseDouble(arreglo[0]), Double.parseDouble(arreglo[1]));
			p2[0]=Double.parseDouble(arreglo[0]);
			p2[1]=Double.parseDouble(arreglo[1]);
			
			arreglo = in.readLine().split(" ");
			
//			Punto p3 = new Punto(Double.parseDouble(arreglo[0]), Double.parseDouble(arreglo[1]));
			p3[0]=Double.parseDouble(arreglo[0]);
			p3[1]=Double.parseDouble(arreglo[1]);
			
			
			double R = Double.parseDouble(in.readLine());
			
			double a = distancia(p1, p2);
			double b = distancia(p2, p3);
			double c = distancia(p1, p3);
			
			double a2= a*a;
			double b2=b*b;
			double c2=c*c;
			
			double AREA = 0.25 * Math.sqrt(4d*a2*b2 - Math.pow((a2+b2-c2), 2.0));
			
			double rCalculado = (2.0*AREA)/(a+b+c);  
			
			
			double respuesta = (((rCalculado-R)/R)*100d);
			
			
//			out.write(df.format(respuesta)+"\n");
//			l = in.readLine();
//		}
		out.printf("%.3f\n", respuesta);
		out.close();
		in.close();
		System.exit(0);

	}


//	static double distancia(Punto p, Punto q){
//		return Math.sqrt(Math.pow(p.x-q.x, 2.0)+Math.pow(p.y-q.y, 2.0));
//	}
	
	static double distancia(double[] p, double[] q){
		return Math.sqrt(Math.pow(p[0]-q[0], 2.0)+Math.pow(p[1]-q[1], 2.0));
	}	


//	static class Punto{
//
//		double x;
//		double y;
//
//		public Punto(double x, double y){
//			this.x = x;
//			this.y = y;
//		}
//
//	}



}
