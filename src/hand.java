import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

class hand {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer stk;
	static final double ERROR = Math.pow(10, -6);

	public static void main(String[] args) throws Exception {

		String cadena;
		DecimalFormat df = new DecimalFormat("0.000000");

		while ((cadena = in.readLine()) != null) {
			double Pr = Double.parseDouble(cadena);
			double Pm = 1-Pr;
		
			double total = 1000;
			double rojas = Pr*total;
			double moradas = Pm*total;
			
			int veces = Integer.parseInt(in.readLine());
			
			double[] finalrojo= new double [veces];
			double[] finalmorado= new double [veces];
			double PROJA = 1;
			double PMORADA = 1;
			for (int i = 0; i < veces; i++) {
				
				stk = new StringTokenizer(in.readLine());
				
				char color = stk.nextToken().charAt(0);
				double Pexito = Double.parseDouble(stk.nextToken());
				
				if (color == 'R') {
					// Si eligio roja
					double acertoRojo = Pexito*rojas;
					double falloRojo = moradas- (Pexito*moradas);
					double Pacumulado = acertoRojo+falloRojo;
					//debug
					finalrojo[i]= acertoRojo/Pacumulado;
					finalmorado[i]= 1-finalrojo[i];
					// oppa debug style
					double probabilidadaesRojas= acertoRojo/Pacumulado;
					PROJA*= probabilidadaesRojas;
					PMORADA*= (1-probabilidadaesRojas);
			
				}else if (color == 'P') {
					
					double acertoMorado = Pexito*moradas;
					double falloMorado = rojas- (Pexito*rojas);
					double Pacumulado = acertoMorado+falloMorado;
					
					finalmorado[i]= acertoMorado/Pacumulado;
					finalrojo[i]= 1-finalmorado[i];
					
					double probabilidadaesMoradas= acertoMorado/Pacumulado;
					PROJA*= (1-probabilidadaesMoradas);
					PMORADA*= probabilidadaesMoradas;
					
				}
			}
			double letotale=1;
			out.write("ROJO: \n");
			for (int i = 0; i < finalrojo.length; i++) {
				letotale*= finalrojo[i];
				out.write(finalrojo[i] +" ");
			}
			out.write("\n");
			
			double letotale2=1;
			out.write("MORADO: \n");
			for (int i = 0; i < finalmorado.length; i++) {
				letotale2*= finalmorado[i];
				out.write(finalmorado[i] +" ");
			}
			out.write("\n");
			out.write(df.format(letotale)+" "+df.format(1-letotale)+"\n");
//			out.write(PROJA+" "+PMORADA+"\n");
			
			
		}
		out.flush();
		out.close();
		in.close();
	}


}
