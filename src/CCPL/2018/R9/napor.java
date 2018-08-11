import java.io.*;
import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;

public class napor {
	
	
	final static int INTtoCHAR = 'a'-'0';

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();


		while(line!=null) {

			int N = Integer.parseInt(line);
			
			LinkedList<BigInteger> ans = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				
				String word = in.readLine();
				
				ans.addAll(findNumbers(word.toCharArray()));			
				
			}			
			
			Collections.sort(ans);
//			System.out.println(ans);

			
			for (int i = 0; i < ans.size(); i++) {
				out.write(ans.get(i)+"\n");
			}

			
			line = in.readLine();
			
		}	
		
		
		in.close();
		out.close();


	}

	private static LinkedList<BigInteger> findNumbers(char[] letters) {
		
		LinkedList<BigInteger> a = new LinkedList<>();
		
		boolean consecutiveNumbers = false;
		
		String word = "";
		
		for (int i = 0; i < letters.length; i++) {
			
			if(letters[i]>='0' && letters[i]<='9') {
				consecutiveNumbers = true;
				
				if(word.equals("0")) {
					 
					word = (char)(letters[i])+"";
					
				} else {
					word+= (char)(letters[i])+"";
				}
				
			}else {	
				consecutiveNumbers = false;
				if (!word.equals("")) {					
					a.add(new BigInteger(word));
//					System.out.println(word);
				}
				word = "";
				
			}
//			System.out.println(word);
			
		}
		
		if(consecutiveNumbers) {
			a.add(new BigInteger(word));
//			System.out.println(word);
		}
		
		
		return a;
	}




}
