
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boiled {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter( new OutputStreamWriter(System.out));
		
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			StringTokenizer skt = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(skt.nextToken());
			int p = Integer.parseInt(skt.nextToken());
			int q = Integer.parseInt(skt.nextToken());
			int eggs[] = new int[n];
			int c = 0;
			int pesoAcum = 0;
			skt = new StringTokenizer(in.readLine());
			for (int j = 0; j < eggs.length; j++) {
				int pesoh = Integer.parseInt(skt.nextToken());
				if (c < p && pesoAcum+pesoh<= q) {
					c++;
					pesoAcum += pesoh;
				}
			}
			
			out.write("Case "+(i+1)+": "+c+"\n");
		}
		out.close();
		
	}
	
}
