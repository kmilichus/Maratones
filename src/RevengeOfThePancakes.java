package QualificationRound;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Stack;

public class RevengeOfThePancakes {
	
	private static char[] stack;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


		int veces = Integer.parseInt(in.readLine());
		int cont = 1;

		while (veces>0) {
			out.write("Case #"+cont+": ");

			String line = in.readLine();

			if (line.length()==1) {
				if (line.equals("+")) {
					out.write("0\n");
				}else {
					out.write("1\n");
				}

			}else if (!line.contains("-")) {
				out.write("0\n");
			}else if (!line.contains("+")) {
				out.write("1\n");
			}else{
				int times = 0;
				char bottom = line.charAt(line.length()-1);				
				
				stack = line.toCharArray();
				
				for (int i = stack.length-2; i >=0; i--) {
					
					if (stack[i]!= bottom) {
						flip(i);
						times++;
					}
					
					
				}
				
				if (bottom =='-') {
					times++;
				}
				
				out.write(times+"\n");
				
			}

			veces--;
			cont++;
		}

		out.flush();
		in.close();
		out.close();


	}

	private static void flip(int i) {
	
		for (int j = i; j >=0; j--) {
			
			if (stack[j]=='+') {
				stack[j]='-';
			}else {
				stack[j]='+';
			}
		}
		
	}

//	private static void flip(int pos) {
//		
//		char[] clon = stack.clone();
//		
//		for (int j = 0, i=pos; j <= i; j++,i--) {
//			
//			char simbolo = clon[j];
//			if (simbolo=='+') {
//				simbolo = '-';
//			}else {
//				simbolo = '+';
//			}
//			
//			stack[i]=simbolo;
//		}
//		
//	}

}
