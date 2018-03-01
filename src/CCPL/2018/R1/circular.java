import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class circular {

	static int[] nums = {113, 131, 197, 199, 311, 337, 373, 719, 733, 919, 971, 991, 1193, 1931, 3119, 3779, 7793, 7937, 9311, 9377, 11939, 19391, 19937, 37199, 39119, 71993, 91193, 93719, 93911, 99371, 193939, 199933, 319993, 331999, 391939, 393919, 919393, 933199, 939193, 939391, 993319, 999331};
	
	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line  = in.readLine();
		while(!line.equals("-1")) {
			String[] arr = line.split(" ");
			int inf = Integer.parseInt(arr[0]);
			int sup = Integer.parseInt(arr[1]);
			int c = 0;
			for (int i = 0; i < nums.length; i++) {
				if (inf<=nums[i] && sup>=nums[i]) {
					c++;
				}
			}
			String response = (c == 0)? "No Circular Primes.": (c == 1)? c + " Circular Prime.":c + " Circular Primes.";
			System.out.println(response);
			line = in.readLine();
		}
		
	}
	
}
