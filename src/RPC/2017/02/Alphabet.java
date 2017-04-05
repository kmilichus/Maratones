import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Alphabet {

	public static void main(String[] args) throws IOException{

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		char[] letters=in.readLine().toCharArray();
		int[] numeroMax=new int[letters.length];
		numeroMax[numeroMax.length-1]=1;
		int secuence=1;
		for (int i = letters.length-2; i >=0; i--) {
			char control=letters[i];
			int max=-1;
			int len=0;
			for (int j = i+1; j < numeroMax.length; j++) {
				if(letters[j]>control){
					if(max<0){
						max=j;
						len=numeroMax[j];
					}else{
						if(len<numeroMax[j]){
							max=j;
							len=numeroMax[j];
						}
					}
				}
			}
			numeroMax[i]=len+1;
			if(numeroMax[i]>secuence){
				secuence=numeroMax[i];
			}
		}
		out.write((26-secuence)+"\n");
		out.close();
		in.close();
		
	}
	
	

}
