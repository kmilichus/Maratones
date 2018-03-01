import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class light {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int numberOfTestCases=Integer.parseInt(in.readLine());
		
		for (int i = 0; i < numberOfTestCases; i++) {
			String[] lectura=in.readLine().trim().split(" ");
			int numberOfLights=Integer.parseInt(lectura[0]);
			int numberOfQuerys=Integer.parseInt(lectura[1]);
			boolean[] prendidas=new boolean[numberOfLights];
			for (int j = 0; j < numberOfQuerys; j++) {
				String[] caso=in.readLine().trim().split(" ");
				int number1=Integer.parseInt(caso[0])-1;
				int number2=Integer.parseInt(caso[1])-1;
				if(number1!=number2) {
					prendidas[number2]=true;
				}
				
			}
			
			int cantidad=0;
			for (int j = 0; j < prendidas.length; j++) {
				if(!prendidas[j]) {
					cantidad++;
				}
			}
			out.write("Case "+(i+1)+": "+cantidad+"\n");
			if(i+1!=numberOfTestCases) {
				in.readLine();
			}
		}
		out.close();

	}

}
