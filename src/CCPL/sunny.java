import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

public class sunny {

	static double EPS=1e-9;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		
		int numberofCases=Integer.parseInt(in.readLine().trim());
		
		for (int i = 0; i < numberofCases; i++) {
			int numberOfDots=Integer.parseInt(in.readLine());
			coord[] dots=new coord[numberOfDots];
			for (int j = 0; j < dots.length; j++) {
				StringTokenizer skt=new StringTokenizer(in.readLine().trim());
				dots[j]=new coord(Integer.parseInt(skt.nextToken()), Integer.parseInt(skt.nextToken()));
				
			}
			Arrays.sort(dots);
			boolean[] mayores=new boolean[numberOfDots];
			mayores[numberOfDots-1]=true;
			double mayor=0;
			for (int j = mayores.length-2; j >=0 ; j--) {
				if(dots[j].y>mayor) {
					mayores[j]=true;
					mayor=dots[j].y;
				}
			}
			coord last=null;
			int index=0;
			double totalDist=0;
			for (int j = 0; j < mayores.length; j++) {
				if(mayores[j]) {
					if(last==null) {
						last=dots[j];
						index=j;
					}else {
						coord actual=dots[j];
						int indexActual=j;
						double m=(last.y-dots[index+1].y)/(last.x-dots[index+1].x);
						double x=((actual.y-last.y)/m)+last.x;
						coord nueva=new coord(x, actual.y);
						totalDist+=dist(last, nueva);
						last=actual;
						index=indexActual;
						
					}
				}
			}
			
			out.format(new Locale("*"),"%.2f%n",totalDist);
			
			
			
		}
		out.close();
		
		

	}
	
	static class coord implements Comparable<coord>{

		
		double x;
		double y;
		
		
		public coord(double x, double y) {
			
			this.x = x;
			this.y = y;
		}


		@Override
		public int compareTo(coord o) {
			if(o.x-x<EPS) {
				return 0;
			}else if(o.x>x) {
				return -1;
			}else {
				return 1;
			}
			
		}
		
		public String toString() {
			return "["+x+","+y+"]";
		}
		
	}
	
	static double dist(coord uno, coord dos) {
		return Math.hypot(uno.x-dos.x, uno.y-dos.y);
	}

}
