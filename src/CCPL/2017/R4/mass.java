import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class mass {

	static char[] g;

	static double[] elements;

	public static int parseNumber(int ind){

		String num = "1";

		if (ind+1 < g.length) {

			if(isNumber(g[ind+1])){

				if(ind+2 < g.length){

					if (isNumber(g[ind+2])) {
						num = ""+g[ind+1]+g[ind+2];	
					}else {
						num = ""+g[ind+1];
					}
				}

				if (num.length()!=2) {					
					num = ""+g[ind+1];
				}

			}


		}


		return Integer.parseInt(num);

	}
	private static boolean isNumber(char c) {

		if(c>= '0' && c<='9')
			return true;

		return false;
	}

	public static void parserLets(){

		for (int i = 0; i < g.length; i++) {
			char l = g[i];
			switch (l) {
			case 'C':
				elements[0]+= parseNumber(i);
				break;
			case 'H':
				elements[1]+= parseNumber(i);
				break;
			case 'O':
				elements[2]+= parseNumber(i);
				break;
			case 'N':
				elements[3]+= parseNumber(i);
				break;
			}
		}

	}

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader (System.in) );
		BufferedWriter out = new BufferedWriter (new OutputStreamWriter(System.out));


		int T = Integer.parseInt(in.readLine());

		while (T-->0) {

			elements = new double[4];
			double[] weights = {12.01, 1.008, 16.00, 14.01};

			g = in.readLine().toCharArray();

			parserLets();

			double molar = 0;

			for (int i = 0; i < weights.length; i++) 		
				molar+= elements[i]*weights[i];



			DecimalFormatSymbols decimalSymbols = DecimalFormatSymbols.getInstance();
			decimalSymbols.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("0.000",decimalSymbols);

			out.write(df.format(molar)+"\n");

		}




		out.close();
		in.close();

	}

}
