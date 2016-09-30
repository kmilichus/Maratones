import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class duelo {

	public static void main(String[] args) throws IOException {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int veces = Integer.parseInt(in.readLine());
		int caso = 1;
		
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
		otherSymbols.setDecimalSeparator(',');
		DecimalFormat df = new DecimalFormat("0.0", otherSymbols);	

		while (veces>0) {

			double largo = Double.parseDouble(in.readLine());
			String[] velocidades = in.readLine().split(" ");
			
			double vHarry = Double.parseDouble(velocidades[0]);
			double vVoldemort = Double.parseDouble(velocidades[1]);
			
			double tiempo = largo / (vHarry+vVoldemort);
			
			out.write("Duelo #"+caso+": "+df.format(vHarry*tiempo)+"\n");
			
			caso++;
			veces--;
		}

		out.flush();
		out.close();
		in.close();

	}

}
