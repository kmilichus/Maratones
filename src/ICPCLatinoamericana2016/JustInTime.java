import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;

public class JustInTime {
	
	
	
	static int num;


	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();
		
		num = Integer.parseInt(linea);
		
		
		while (!esPrimo()) 
			num--;		
		
		
		out.write(num+"\n");

		in.close();
		out.close();
	}


	private static boolean esPrimo() {
		
		boolean primo = true;
		for (int i = 2; i < Math.ceil(Math.sqrt(num)) && primo; i++) {			
			if (num%i==0) 
				primo = false;			
		}
		return primo;
	}



}