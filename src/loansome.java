import java.io.BufferedReader;
import java.io.InputStreamReader;


public class loansome {


	public static void main(String[] args) throws Exception{

		BufferedReader l = new BufferedReader(new InputStreamReader(System.in));
		int duracion, depreciacion, pos;
		double cuota, valor, deuda, tasa;
		boolean parada;
		StringBuilder sb = new StringBuilder();
		double[] porcentajes;
		String[] datos= new String[4];
		String[] tasas_interes= new String[2];
		String line="";
		line = l.readLine();
		datos = line.split(" ");
		duracion = Integer.parseInt(datos[0]);

		while(duracion>0){
			cuota = Double.parseDouble(datos[1]);
			valor = Double.parseDouble(datos[2]);
			depreciacion = Integer.parseInt(datos[3]);
			tasa = -1;
			parada = false;
			porcentajes = new double[110];
			deuda = valor;
			valor+= cuota;
			cuota = deuda/duracion;
			
			for (int i = 0; i < porcentajes.length; i++) {
				porcentajes[i]=-1.0;
			}
			
			for (int i = 0; i < depreciacion; i++) {
				line = l.readLine();
				tasas_interes = line.split(" ");
				pos = Integer.parseInt(tasas_interes[0]);
				porcentajes[pos]= Double.parseDouble(tasas_interes[1]);
			}
			
			outer:
			for (int i = 0; i <= duracion && !parada; i++) {
				if(i ==0){
					tasa = porcentajes [i];
					valor -= valor*tasa;
					if(deuda<valor){
						sb.append(i+" months\n");
						break outer;
					}
				}
				else{
					if(porcentajes[i] != -1.0)
						tasa = porcentajes[i];

					deuda = deuda - cuota;
					valor -=	 valor*tasa;

					if(deuda<valor){
						parada = true;
						if(i == 1)
							sb.append(i+" month\n");
						else
							sb.append(i+" months\n");
					}

				}

			}
			line = l.readLine();
			datos = line.split(" ");
			duracion = Integer.parseInt(datos[0]);
		}

		System.out.print(sb);

	}

}
