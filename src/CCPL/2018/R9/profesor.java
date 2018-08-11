import java.io.*;
import java.util.StringTokenizer;

public class profesor {

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();


		while(line!=null) {

			int N = Integer.parseInt(line);

			int[] arr1 = new int[N];
			int[] arr2 = new int[N];


			StringTokenizer stk = null;

			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(in.readLine());
				arr1[i] = Integer.parseInt(stk.nextToken());
				arr2[i] = Integer.parseInt(stk.nextToken());
			}

			int[] ans = new int[6];

			for(int i = 1;i<=5;i++){
				ans[i] = 0;

				for(int j = 0,cont = 0;j<N;++j){

					if(arr1[j]==i || arr2[j]==i) 
						cont++;
					else 
						cont = 0;

					ans[i] = Math.max(ans[i],cont);
				}
			}


			int best = -1;
			int grade = -1;

			for(int i = 1;i<=5;++i){
				if(ans[i]>best){
					best = ans[i];
					grade = i;
				}
			}
			
			
			out.write(best+" "+grade+"\n");


			line = in.readLine();

		}	
		in.close();
		out.close();


	}




}
