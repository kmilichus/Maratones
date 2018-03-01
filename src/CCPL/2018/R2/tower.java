import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tower {


	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


		int n = Integer.parseInt(in.readLine());

		int caso = 1;

		while (n!=0) {


		Bloque[] bloques = new Bloque[n*3];

			for (int i = 0; i < n; i++) {

				 StringTokenizer stk = new  StringTokenizer(in.readLine());
				 int x  = Integer.parseInt(stk.nextToken());
				 int y  = Integer.parseInt(stk.nextToken());
				 int z  = Integer.parseInt(stk.nextToken());

				 
				 bloques[i*3] =		new Bloque(x, y, z);
				 bloques[i*3 +1] =	new Bloque(y, z, x);
				 bloques[i*3 +2] =	new Bloque(z, x, y);
			}

			
			
			Arrays.sort(bloques);
				
			
			
			int[] alturaMaxima = new int[bloques.length];
			
			for (int i = 0; i < bloques.length; i++) {
				alturaMaxima[i]= bloques[i].z;
			}
		
//			System.out.println(Arrays.toString(bloques));
//			System.out.println(Arrays.toString(alturaMaxima));
			int alturaMax=0;
			for (int i = alturaMaxima.length-1; i >=0; i--) {
				
				int hMax = 0;
				
				for (int j = i+1; j < alturaMaxima.length; j++) {
					
					
					if(bloques[j].x < bloques[i].x && bloques[j].y < bloques[i].y||bloques[j].y < bloques[i].x && bloques[j].x < bloques[i].y) {
						
						if (hMax<alturaMaxima[j]) {
							hMax = alturaMaxima[j];
						}
					}
				}
				
				
				alturaMaxima[i]+= hMax;
				if(alturaMax<alturaMaxima[i]) {
					alturaMax=alturaMaxima[i];
				}
				
			}
			
//			System.out.println(Arrays.toString(alturaMaxima));
			n = Integer.parseInt(in.readLine());
			out.write("Case "+caso+": maximum height = "+alturaMax+"\n");
			caso++;
		}

		out.close();
		in.close();

	}
	
	
	static class Bloque implements Comparable<Bloque> {
		
		
		int x;
		int y;
		int z;
		public Bloque(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		
		@Override
		public int compareTo(Bloque bl) {
			
			int area = bl.x * bl.y;
			int area2 = x*y;
			
//			if(area == area2)
//				return bl.z -z;
			
			
			return area-x*y;
		}
		
		
		@Override
		public String toString() {
			
			return x+ " "+ y+" "+z;
		}
		
		
	
	}

}
