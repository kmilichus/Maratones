package GoogleCodeJam2017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OversizedPancakeFlipper {

	static char[] PancakeFlipperArray;
	public static void main(String[] args) throws IOException{
		BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter Salida=new BufferedWriter(new OutputStreamWriter(System.out));
		int numberOfCases=Integer.parseInt(lector.readLine());
		int i = 0;
		while(i<numberOfCases){
			StringTokenizer datos=new StringTokenizer(lector.readLine().trim());
			PancakeFlipperArray=datos.nextToken().toCharArray();
			int K=Integer.parseInt(datos.nextToken());
			int numberOfFlips=0;
			boolean itsPosible=true;
			for (int j = 0; j < PancakeFlipperArray.length&&itsPosible; j++) {
				if(PancakeFlipperArray[j]=='-'){
					if(swap(j, K)){
						numberOfFlips++;
					}else{
						itsPosible=false;
					}
				}
			}
			if(itsPosible){
				Salida.write("Case #"+(i+1)+": "+numberOfFlips+"\n");
			}else{
				Salida.write("Case #"+(i+1)+": IMPOSSIBLE\n");
			}
			i++;
		}
		Salida.close();
		lector.close();

	}
	static boolean swap(int inicio, int k){
		if(inicio+k>PancakeFlipperArray.length){
			return false;
		}else{
			for (int i = inicio; i < inicio+k; i++) {
				if(PancakeFlipperArray[i]=='-'){
					PancakeFlipperArray[i]='+';
				}else{
					PancakeFlipperArray[i]='-';
				}
			}
			return true;
		}
	}

}
