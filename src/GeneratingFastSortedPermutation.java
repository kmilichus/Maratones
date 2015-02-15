import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GeneratingFastSortedPermutation {


	static char[] datos;

	public static void main(String[] args) throws Exception {
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		int i,j;
		int Case = Integer.parseInt(lector.readLine());
		boolean Continua;
		
		while(Case > 0) {
			datos = lector.readLine().toCharArray();
			ordenar(datos,0);
			System.out.println(datos);
			salir:
			while(true) {
				Continua = false;
				for(i=datos.length-2; i>=0 && !Continua; i--)
					for(j=datos.length-1; j>i; j--) {
						if(datos[j] > datos[i]) {
							swap(j,i);
							Continua = true;
							ordenar(datos,i+1);
							break;
						}
					}
				if(!Continua)
					break salir;
				else
					System.out.println(datos);
			}
			System.out.println();
			Case--;
		}
	}


	private static void swap(int x,int y) {
		char temp = datos[x];
		datos[x] = datos[y];
		datos[y] = temp;
	}

	private static void ordenar(char[] a,int cur) {
		int i,j;
		for(i=0; i<a.length-cur; i++)
			for(j=cur; j<a.length-i-1; j++)
				if(datos[j]>datos[j+1])
					swap(j,j+1);
	}
}