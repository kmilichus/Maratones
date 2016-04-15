import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

public class eggs_CribaBitSet {

	public static BitSet primos;


	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea = in.readLine();
		calcularPrimos(1000000);	
		//		System.out.println(primos);

		while (linea!=null) {

			int veces = 0;
			int lanzar = 0;
			int eggs = Integer.parseInt(linea);

			while (eggs!=0) {
				lanzar = calcularTam(eggs);	
				veces++;
				eggs-= lanzar;
			}
			
			out.write(veces+"\n");
			linea = in.readLine();
		}

		out.flush();
		out.close();
		in.close();

	}

	private static int calcularTam(int eggs) {

		int menorResiduo = 1;
		int ganador=0;

		for (int i = eggs; i>0 && menorResiduo!=0; i--) {
			if (primos.get(i)) {
				int residuo = eggs%i;
				if (residuo<menorResiduo) {
					menorResiduo = residuo;
					ganador = i;
				}else if (residuo==menorResiduo) {
					ganador = i;
				}
			}
		}
		return ganador;
	}

	public static BitSet calcularPrimos(int limit){
		primos = new BitSet();
		primos.set(0, false);
		primos.set(1, false);
		primos.set(2, limit, true);
		
		for (int i = 0; i * i < limit; i++){
			if (primos.get(i)){
				for (int j = i * i; j < limit; j += i){
					primos.clear(j);
				}
			}
		}
		return primos;
	}

	
	public static int[] a (int b){

		int x[]= new int[b];
		x[0]=1;
		x[1]=1;
		x[2]=0;
		
		for (int y = 0; y * y < b; y++){
			if (x[y]!=1){
				for (int z = y * y; z < x.length; z += y){
					x[z]=1;
				}
			}
		}
		return x;
	}

}
