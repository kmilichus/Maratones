import java.io.*;
import java.util.StringTokenizer;

public class tabovi {

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();


		while(line!=null) {

			int N = Integer.parseInt(line);

			StringTokenizer stk = new StringTokenizer(in.readLine());

			int[] initial = new int[N];

			for (int i = 0; i < N; i++) {
				initial[i] = Integer.parseInt(stk.nextToken());
			}

			int[] goal = new int[N];
			
			stk = new StringTokenizer(in.readLine());

			for (int i = 0; i < N; i++) {
				goal[i] = Integer.parseInt(stk.nextToken());
			}

			int value = 0;
			int position = 0;
			int negatives = 0;

			for(int i = N-1 ; i>=0 ; i--){

				int current = goal[i]-initial[i]-value;
				value += current;

				if(current<0) 
					negatives -= current;
				else 
					position += current;
			}

			position = Math.max(position, negatives);

			out.write(position+"\n");


			line = in.readLine();

		}	


		in.close();
		out.close();


	}




}
