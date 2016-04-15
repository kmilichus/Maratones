import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * Uva problem 	10855	Rotated square
 * @author Camilo Barrios
 *
 */

public class RotatedSquare {
	
	public static char[][] big;
	public static char[][] small;

	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String linea = in.readLine();
		
		while (!linea.equals("0 0")) {
		
			StringTokenizer stk = new StringTokenizer(linea);
			
			int N = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			big = new char[N][N];
			small = new char[n][n];
			
			for (int i = 0; i < N; i++) 
				big[i]= in.readLine().toCharArray();
			
			for (int i = 0; i < n; i++) 
				small[i]= in.readLine().toCharArray();
			
			out.write(contarApariciones()+" ");
//			imprimir();
			rotarDerecha();
			out.write(contarApariciones()+" ");
//			imprimir();
			rotarDerecha();
			out.write(contarApariciones()+" ");
//			imprimir();
			rotarDerecha();
			out.write(contarApariciones()+"\n");
//			imprimir();
			linea = in.readLine();	
		}
			
		out.flush();
		in.close();
		out.close();
		
		

	}
	
	
	public static void imprimir(){
		
		for (int i = 0; i < small.length; i++) {
			
			for (int j = 0; j < small.length; j++) {
				System.out.print(small[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	public static void rotarDerecha(){
		// para cualquier (f,c) ----> (c,n-f-1)
		//Convertir pos matriz
		
		char[][] nueva = new char[small.length][small.length];
		
		for (int i = 0; i < small.length; i++) {
			for (int j = 0; j < small.length; j++) {
				
				nueva[j][small.length-i-1]= small[i][j]; 
				
			}
		}
		
		
		small = nueva;
	}
	
	public static int contarApariciones(){
		int cont = 0;
		
		for (int i = 0; i < (big.length - small.length)+1; i++) {
			
			for (int j = 0; j < (big.length - small.length)+1; j++) {
				
				if (big[i][j]==small[0][0]) {
//					System.out.println("---------------------NUEVA COMPARACION EN "+i+" - "+j+"--------------");
					boolean ok = true;
					for (int i2 = 0; i2 < small.length && ok; i2++) {
						for (int j2 = 0; j2 < small.length && ok; j2++) {
							
							if (big[i+i2][j+j2]!=small[i2][j2]) {
								ok = false;
//							   System.out.println("Diferencia en la casilla "+(i+i2)+" - "+(j+j2)+" con la small "+i2+" - "+j2);
							}
						}
					}
					if (ok) {
						cont++;
//						System.out.println("Ok en la pos grande "+i+ " - "+j);
					}
					
					
				}
				
			}
		}
		
		return cont;
	}

}