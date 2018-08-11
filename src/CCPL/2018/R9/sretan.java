import java.io.*;

public class sretan {

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();


		while(line!=null) {

			long N = Long.parseLong(line);
			N++;
			
			String binary = Long.toBinaryString(N);
			String n = "1"+binary;

			
			String binary2 = binary.replace('0', '4');
			binary2 = binary2.replace('1', '7');
			
//			out.write(binary+" -->"+ binary2.substring(1)+"\n");
			out.write(binary2.substring(1)+"\n");
			
			line = in.readLine();
			
		}	
		
		
		in.close();
		out.close();


	}




}
