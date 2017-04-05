import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class dpa01 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
	
		int T = Integer.parseInt(in.readLine());
		int num;
		int sum;
		while(T-- > 0){
			num = Integer.parseInt(in.readLine());
			sum = 0;
			for (int i = 1; i < num; i++) {
				if(num%i == 0) sum+=i;
			}
			
			if(sum < num) out.write("deficient\n");
			else if(sum > num) out.write("abundant\n");
			else out.write("perfect\n");
			
			
		}
		out.flush();
		return;
	}

}
