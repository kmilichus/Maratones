
public class ClaseSeamana6Arreglos {


	private int[] numeros;

	public ClaseSeamana6Arreglos(){

		numeros = new int[10];
		numeros[0]= 1;
		numeros[1]= 2;
		numeros[2]= 3;
		numeros[3]= 3;
		numeros[4]= 1;
		numeros[5]= 1;
		numeros[6]= 2;
		numeros[7]= 1;
		numeros[8]= 2;
		numeros[9]= 3;
	}

	public int sumarNumeros(){
		int suma = 0;
		suma += numeros[0];
		suma += numeros[1];
		suma += numeros[2];
		suma += numeros[3];
		suma += numeros[4];
		suma += numeros[5];
		suma += numeros[6];
		suma += numeros[7];
		suma += numeros[8];
		suma += numeros[9];	
		return suma;
	}

	public int[] frecuencia(){
		int[] frecuencia = new int[3];
		frecuencia = auxiliar(0,frecuencia);
		frecuencia = auxiliar(1,frecuencia);
		frecuencia = auxiliar(2,frecuencia);
		frecuencia = auxiliar(3,frecuencia);
		frecuencia = auxiliar(4,frecuencia);
		frecuencia = auxiliar(5,frecuencia);
		frecuencia = auxiliar(6,frecuencia);
		frecuencia = auxiliar(7,frecuencia);
		frecuencia = auxiliar(8,frecuencia);
		frecuencia = auxiliar(9,frecuencia);
		return frecuencia;
	}

	public int[] auxiliar(int posActual, int[]acumulado){
		if (numeros[posActual]==1) {
			acumulado[0]++;
		}else if (numeros[posActual]==2) {
			acumulado[1]++;
		}else {
			acumulado[2]++;
		}
		return acumulado;
	}

	public int[] frecuencia2(){
		int[] frecuencia = new int[3];

		for(int indice = 0; indice<10; indice++){	
			if (numeros[indice]==1) {
				frecuencia[0]++;
			}else if (numeros[indice]==2) {
				frecuencia[1]++;
			}else {
				frecuencia[2]++;
			}
		}
		return frecuencia;
	}


}
