

import java.io.*;
import java.util.Arrays;

public class ExactSum {
	


	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));

		String line = in.readLine();


		while(true){
			 
			
			int N = Integer.parseInt(line);
			
			int[] books = new int[N];
			
			String[] a = in.readLine().split(" ");
			
			
			 for (int i = 0; i < N; ++i)
		            books[i] = Integer.parseInt(a[i]);
		        
		        
			 Arrays.sort(books);
		        
			 int M = Integer.parseInt(in.readLine());
		        
		        int i = 0, j = N - 1;
		        int low = 0, top =0;
		        while (i < j)
		        {
		            if (books[i] + books[j] < M)
		                ++i;
		            else if (books[i] + books[j] == M)
		            {
		                low = i;
		                top = j;
		                ++i; --j;
		            }
		            else
		                --j;
		        }
		        
		        out.write("Peter should buy books whose prices are " + books[low] + " and " + books[top] + ".\n\n");
		
			line = in.readLine();
			line = in.readLine();
			if(line==null)
				break;
			
		}

		in.close();
		out.close();
	}



}
