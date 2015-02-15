import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Light{

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));       

		long pos= Long.parseLong(in.readLine());

		while (pos != 0) {

			long x = (long) Math.sqrt(pos);
			
			if(x*x == pos)
				out.write("yes\n");
			else
				out.write("no\n");
			
			
			pos= Long.parseLong(in.readLine());
		}

		in.close();
		out.flush();
		out.close();
	}
}
