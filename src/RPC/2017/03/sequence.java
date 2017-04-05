import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class sequence {
	

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(in.readLine());
		long S, ans;
		while(T-- > 0){
			S = Long.parseLong(in.readLine());
			S++;
			ans = (S*S)-1;
			out.write(ans+"\n");
		}
		
		out.flush();
		in.close();
		out.close();
		
		
	}

}
