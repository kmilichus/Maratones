import java.io.*;
import java.util.*;

public class PolygonArea {




	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));

		
		String line = in.readLine();
		
		
		while (!line.equals("0")) {
		
			int size = Integer.parseInt(line);
			
			double[] X = new double[size];
			double[] Y = new double[size];
			
			
			for (int i = 0; i < size; i++) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				X[i] = Integer.parseInt(stk.nextToken());
				Y[i] = Integer.parseInt(stk.nextToken());
			}
			
	
			out.write(lado(X,Y)+" ");
			
			out.printf("%.1f", polygonArea(X, Y, size));
			out.write("\n");
			line = in.readLine();
		}
		
		
	

		out.close();
		in.close();


	}

	static String lado(double[] X, double[] y) {
		
		int CW = 0;
		
		for (int i = 0; CW==0; i++) {
			
			if(X[i]==X[i+1]){
				continue;
			} else if (X[i]>X[i+1]) {
				CW =2;
			}else {
				CW =1;
			}		
		}
		
		return CW==2? "CW":"CCW";
	}

	static double polygonArea(double X[], double Y[], int n){

	    double area = 0.0;
	 
	    int j = n - 1;
	    for (int i = 0; i < n; i++)
	    {
	        area += (X[j] + X[i]) * (Y[j] - Y[i]);
	        j = i;  
	    }
	 
	    return Math.abs(area / 2.0);
	}
	
	
	


}