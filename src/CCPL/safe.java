import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class safe {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String line=in.readLine();
		int[] numeros=calcular();
		while(line!=null) {
			if(line.equals("")) {
				line=in.readLine();
			}else {
				int number=Integer.parseInt(line.trim());
				if(number==1) {
					out.write("1\n");
				}else if(number==2) {
					out.write("2\n");
				}else {
					int numeroFormas=numeros[number];
					out.write(numeroFormas+"\n");
				}
				line=in.readLine();
			}
		}
		out.close();
		

	}
	
	static int[] calcular() {
		int[] numeros=new int[11];
		int[] sumas=new int[11];
		numeros[1]=1;
		numeros[2]=2;
		numeros[3]=5;
		numeros[4]=14;
		int sumaAnterior=7;
		for (int i = 4; i < sumas.length; i++) {
			numeros[i]=sumaAnterior*2;
			sumaAnterior+=numeros[i];
		}
		return numeros;
	}

}
