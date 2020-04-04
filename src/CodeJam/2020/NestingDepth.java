import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NestingDepth {
	
	
	public static StringBuilder sb;
	public final static char OPEN = '(';
	public final static char CLOSE = ')';
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		int counter = 1;

		while(T-->0) {
			
			sb = new StringBuilder();
			
			char[] sequence = in.readLine().toCharArray();
			
			if(sequence.length == 1) {
				int val = (int)(sequence[0]-'0');
				appendChars(val, OPEN);
				appendChars(1, sequence[0]);
				appendChars(val, CLOSE);
			}else {
				int balance = (int)(sequence[0]-'0');
				appendChars(balance, OPEN);
				appendChars(1, sequence[0]);
				int delta = 0;
			
				for (int i = 1; i < sequence.length; i++) {
					delta = balance - (int)(sequence[i]-'0');
					
					if (delta == 0) {
						//Equal just print next to each other.
						appendChars(1, sequence[i]);
					} else if (delta < 0) {
						//Next number is greater, Open before.
						int distance  = delta*-1;
						appendChars(distance, OPEN);
						balance += (distance);
						appendChars(1, sequence[i]);
					} else {
						//Next number is smaller, Close before.
						appendChars(delta, CLOSE);
						balance -= delta;
						appendChars(1, sequence[i]);
					}	
				}
				//final closure
				appendChars(balance, CLOSE);	
			}
			
			out.write("Case #"+counter+": "+sb.toString()+"\n");
			counter++;
		}

		out.flush();
		in.close();
		out.close();
	}
	
	
	public static void appendChars(int n, char x){
		for (int i = 0; i < n; i++) {
			sb.append(x);
		}
	}
}
