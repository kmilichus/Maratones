import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ljutnja {

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();


		while(line!=null) {

			StringTokenizer stk = new StringTokenizer(line);

			int candies = Integer.parseInt(stk.nextToken());
			int kids = Integer.parseInt(stk.nextToken());

			long[] wishes = new long[kids];

			for (int i = 0; i < kids; i++) {
				wishes[i] = Long.parseLong(in.readLine());
			}


			Arrays.sort(wishes);


			long low = 0;
			long high = wishes[kids-1];
			long mid = 0;


			while(low!=high){
				mid = (low+high+1)/2;

				int maxCandies = candies;

				for(int i = 0; i<kids ; i++)
					if(wishes[i]>mid)
						maxCandies -= wishes[i]-mid;

				if(maxCandies>0) 
					high = mid-1;
				else 
					low = mid;
			}

//			System.out.println("Ordenado -> "+Arrays.toString(wishes));
//			System.out.println("pivote "+ (low+1) );
			
			low++;

			for(int i = kids-1 ; i>=0 ; i--){
				
				if(wishes[i]>low){
					candies -= wishes[i]-low;
					wishes[i] -= wishes[i]-low;
				}
			}

			low--;
			
//			System.out.println("Fixed -->"+Arrays.toString(wishes));
//			System.out.println("Faltan por repartir -> " +candies);

//			for(int i = kids-1 ; i>=0 && candies>0 ; i--){
//				if(wishes[i]>low){
//					candies--;
//					wishes[i]--;
//				}
//			}
			
			
			int i = kids-1;
			
			while (candies>0) {
				if(wishes[i]>low){
					candies--;
					wishes[i]--;
				}
				i--;
				if(i<0)
					i = kids-1;
			}


//			System.out.println(candies);

			
//			BigInteger ans = new BigInteger("0");
			long x = 0;

			for(int j = 0; j<kids ; j++) {
				long num = wishes[j]*wishes[j];
//				String numString = num+"";
				x += num;
			}
			
			out.write(x+"\n");



			line = in.readLine();

		}	


		in.close();
		out.close();






	}




}
