


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GettingTheDigits {
	
	
	public static String[] digits0 =  {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
	public static String[] digits1 =  { "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE","ZERO"};
	public static String[] digits2 =  { "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE","ZERO" ,"ONE"};
	public static String[] digits3 =  { "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE","ZERO" ,"ONE","TWO"};
	public static String[] digits4 =  { "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE","ZERO" ,"ONE","TWO","THREE"};
	public static String[] digits5 =  { "FIVE", "SIX", "SEVEN", "EIGHT", "NINE","ZERO" ,"ONE","TWO","THREE","FOUR"};
	public static String[] digits6 =  { "SIX", "SEVEN", "EIGHT", "NINE","ZERO" ,"ONE","TWO","THREE","FOUR","FIVE"};
	public static String[] digits7 =  { "SEVEN", "EIGHT", "NINE","ZERO" ,"ONE","TWO","THREE","FOUR","FIVE","SIX"};
	public static String[] digits8 =  { "EIGHT", "NINE","ZERO" ,"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN"};
	public static String[] digits9 =  { "NINE","ZERO" ,"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT"};
	
	public static char ONE = '1';

	public static LinkedList<Character> number;

	public static void main(String[] args) throws IOException {
		
		
		ArrayList<String[]> digits = new ArrayList<String[]>();
		
		digits.add(digits0);
		digits.add(digits1);
		digits.add(digits2);
		digits.add(digits3);
		digits.add(digits4);
		digits.add(digits5);
		digits.add(digits6);
		digits.add(digits7);
		digits.add(digits8);
		digits.add(digits9);


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int veces = Integer.parseInt(in.readLine());
		int cont =1;

		while (veces>0) {

			StringBuilder sb = new StringBuilder();
			String line = in.readLine();
			number = new LinkedList<>();

			for (int i = 0; i < line.length(); i++) {
				number.add(line.charAt(i));
			}



			int pos = 0;
			int wow = 0;

			while (!number.isEmpty()) {
				 
				LinkedList<Character> clon = (LinkedList<Character>) number.clone();
				boolean ok = true;
				int found = 0;

				for (int i = 0; i < digits.get(wow)[pos].length() && ok && pos<10; i++) {
					char actual = digits.get(wow)[pos].charAt(i);
					boolean erased = false;
					outer:
					for (int j = 0; j < clon.size(); j++) {

						if (clon.get(j)==actual) {
							clon.remove(j);
							found++;
							erased = true;
							break outer;
						}
					}
					
					if (!erased) {
						ok = false;
					}

				}
				
				
				if (!ok) {
					pos++;
				}else {
					number = (LinkedList<Character>) clon.clone();
					
					sb.append((pos+wow)%10);
				}

//				System.out.println(sb.toString()+" con la pos "+pos);
//				System.out.println(number);

				if (pos==10 && !number.isEmpty()) {
//					System.out.println("wow: "+wow);
//					System.out.println(number);
					
					number = new LinkedList<>();
					clon = new LinkedList<>();
					sb = new StringBuilder();
					for (int i = 0; i < line.length(); i++) {
						number.add(line.charAt(i));
					}
					wow++;
					pos=0;
				}
			}
			
			if (!number.isEmpty()) {
				System.out.println("caso N "+cont);
				System.out.println(number);
			}

			String ans = sb.toString();
			
			char[] arr = ans.toCharArray();
			
			Arrays.sort(arr);

			sb = new StringBuilder();
			
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}

			out.write("Case #"+cont+": "+sb.toString()+"\n");
			veces --;
			cont++;
		}


		out.flush();
		out.close();
		in.close();
	}



}
