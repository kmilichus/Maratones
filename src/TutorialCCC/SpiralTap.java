import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpiralTap {


	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));


		String linea = in.readLine();

		while (!linea.equals("0 0")) {

			StringTokenizer stk = new StringTokenizer(linea);

			int tam = Integer.parseInt(stk.nextToken());
			int pos = Integer.parseInt(stk.nextToken());

			//			System.out.println(linea);
			int[] retorno = encontrarPos(tam, pos);
			//			System.out.println(Arrays.toString(retorno));
			System.out.println("Line = "+retorno[0]+", column = "+retorno[1]+".");					


			linea = in.readLine();
		}

	}

	public static int[] encontrarPos(int tam, int pos){

		int[] retorno =new int[2];

		int b = encontrarMayor( tam,  pos);
		int a = b-2;

		long bb=b*b;
		long aa=a*a;
		long gap = bb-pos;
//		System.out.println("b: "+b+" gap: "+gap);
		
		if (pos == bb) {
			// ya la encontre en b
//			System.out.println("pos es b");
			retorno[0]= b;
			retorno[1]= b;

		}else if(pos==aa){
			// ya lo encontre en a
//			System.out.println("pos es a");
			if (a==1) {
				retorno[0]= (tam/2)+1;
				retorno[1]= (tam/2)+1;
			} else if (pos==tam*tam) {
				retorno[0]= a;
				retorno[1]= a;		
			}else{
				retorno[0]= b-1;
				retorno[1]= b-1;
			}

		}else if (gap<= tam-1) {
//			System.out.println("Caso A");
			retorno[0]= (int) (tam-gap);
			retorno[1]= tam- (tam-b);

		}else if (gap <= 2*(tam-1)) {
//			System.out.println("Caso B");
			retorno[0]= tam- (tam-b);
			retorno[1]= (int) (tam-(gap-tam));

		}else if (gap <= 3*(tam-1)) {
//			System.out.println("Caso C");
			retorno[0]= (int) (1+(gap-(2*(tam-1))));
			retorno[1]= tam- (tam-b);
		}else {
//			System.out.println("Caso D");
			retorno[0]= b;
			retorno[1]= (int) (1+(gap-(3*(b-1))));
		}		



		return retorno;

	}

	private static int encontrarMayor(int tam, int pos) {
		int r = 0;
		boolean parar = false;

		for (long i = 1;!parar; i+=2) {
			if (i*i>pos) {
				r=(int) i;
				parar = true;
			}

		}
		return r;
	}



}