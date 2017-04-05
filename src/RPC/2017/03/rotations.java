import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class rotations {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
	
		int T = Integer.parseInt(in.readLine());
		int a = 31;
		int b;
		int c, cant;
		long temp;
		
		boolean nums[];
		while(T-- > 0){
			cant = 0;
			nums = new boolean[32];
			temp = Long.parseLong(in.readLine());
			b = (int) temp;
			for (int i = 0; i < 32; i++) {				
				c = b & a;
				b = Integer.rotateRight(b, 1);				
				if(!nums[c]){
					cant++;
					nums[c] = true;
				}

				
			}
			out.write(cant > 31? "yes\n":"no\n");
		}
		out.close();
		in.close();		

	}

}
