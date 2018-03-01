import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class price {

	public static void main(String[] args) throws IOException{
		//lectores
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String line=in.readLine();
		long[] dp=new long[301];
		boolean[] calculado=new boolean[301];
		
		int[] monedas=new int[300];
		for (int i = 0; i < monedas.length; i++) {
			monedas[i]=i+1;
		}
		
		while(line!=null) {
			String [] numbers=line.split(" ");
			int primero=Integer.parseInt(numbers[0]);
			
			
			
			switch (numbers.length) {
			case 1:
				out.write(countWays(monedas, 300, primero)+"\n");
				break;
			case 2:
				int segundo=Integer.parseInt(numbers[1]);
				
				if(segundo>300) {
					if(!calculado[300]) {
						dp[300]=countWays(monedas,300, primero);
						calculado[300]=true;
					}
					out.write(dp[300]+"\n");

					
					
				}else {
					if(!calculado[segundo]) {
						dp[segundo]=countWays(monedas, segundo, primero);
						calculado[segundo]=true;
					}
					out.write(dp[segundo]+"\n");
					
				}
					
				break;
			case 3:
	
				int segundo1=Integer.parseInt(numbers[1]);
				int tercero=Integer.parseInt(numbers[2]);
				if(tercero>300&&segundo1>300) {
					out.write(0+"\n");
					
				}else if(segundo1>300) {
					out.write(0+"\n");
					
				}else if(tercero>300){
					if(!calculado[segundo1]) {
						dp[segundo1]=countWays(monedas, segundo1, primero);
						calculado[segundo1]=true;
					}
					
					
					
					out.write((dp[segundo1])+"\n");
				}else {
					
					if(!calculado[tercero]) {
						dp[tercero]=countWays(monedas, tercero, primero);
						calculado[tercero]=true;
					}
					
					if(!calculado[segundo1-1]) {
						dp[segundo1-1]=countWays(monedas, segundo1-1, primero);
						calculado[segundo1-1]=true;
					}
					
					
					
					out.write((dp[tercero]-dp[segundo1-1])+"\n");
					
				}
				
				
				break;
			}
			line=in.readLine();
		}
		out.close();
	}
	
	
	static long countWays(int S[], int m, int n)
    {
       
        long[] table = new long[n+1];
 
        Arrays.fill(table, 0);   
 
        table[0] = 1;
 
        
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    }

}
