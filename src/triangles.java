import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class triangles {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer stk;
	static final double ERROR = Math.pow(10, -6);

	public static void main(String[] args) throws Exception {

		String cadena;

		while ((cadena = in.readLine()) != null) {
			int N = Integer.parseInt(cadena);

			Punto[] puntos;
			ArrayList<Punto> losPuntos = new ArrayList<Punto>();

			int triangulos = 0;
			//Lectura de los puntos
			for (int n = 0; n < N; n++) {
				stk = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				Punto elPunto = new Punto(x, y);
				//solo los pone en el arreglo si no estan repetidos
				if (!existeEnElArreglo(elPunto, losPuntos)) {

					losPuntos.add(elPunto);

				}

			}
			//convierte la lista en un arreglo
			puntos = new Punto[losPuntos.size()];
			losPuntos.toArray(puntos);
			//comprueba que el arreglo tenga mas de dos triangulos para que empiece a tomarlos
			if (puntos.length <= 2) {
				out.write("0\n");

			}
			else {

				for (int i = 0; i < puntos.length; i++) {
					Punto a = puntos[i];
					for (int j = i + 1; j < puntos.length; j++) {
						Punto b = puntos[j];
						for (int k = j + 1; k < puntos.length; k++) {
							Punto c = puntos[k];
							if (NoSonCoLineales(a, b, c)) { // verfica si a b c no son colineales
								
								// crea los tres segmentos del triangulo
								double AB = distancia(a, b);
								double AC = distancia(a, c);
								double BC = distancia(b, c);
								
								// comprueba si el triangulo tiene solo dos lados iguales
								if (Math.abs(AB - AC) <= ERROR && Math.abs(AB - BC) >= ERROR) {
									triangulos++;
								}
								else if (Math.abs(AB - BC) <= ERROR && Math.abs(BC - AC) >= ERROR) {
									triangulos++;
								}
								else if (Math.abs(AC - BC) <= ERROR && Math.abs(AC - AB) >= ERROR) {
									triangulos++;
								}

							}

						}
					}

				}

				out.write(triangulos + "\n");
			}

		}

		out.flush();
		out.close();
		in.close();
	}

	static double distancia(Punto a, Punto b) {

		return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));

	}

	static boolean NoSonCoLineales(Punto a, Punto b, Punto c) {

		double m1 = (a.x - b.x) != 0 ? (a.y - b.y) / (a.x - b.x) : Double.MAX_VALUE;
		double m2 = (a.x - c.x) != 0 ? (a.y - c.y) / (a.x - c.x) : Double.MAX_VALUE;
		double m3 = (c.x - b.x) != 0 ? (c.y - b.y) / (c.x - b.x) : Double.MAX_VALUE;

		return (m1 != m2 && m2 != m3 && m1 != m3);

	}

	static boolean existeEnElArreglo(Punto p, ArrayList<Punto> puntos) {

		boolean retorno = false;
		if (puntos.isEmpty()) {
			retorno = false;
		}
		else {
			for (int i = 0; i < puntos.size() && !retorno; i++) {
				if (p.x == puntos.get(i).x && p.y == puntos.get(i).y)
					retorno = true;

			}
		}
		return retorno;

	}

	static class Punto {
		int x;

		int y;
		double magnitud;

		public Punto(int x, int y) {
			this.x = x;
			this.y = y;
			this.magnitud = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		}

	}
}
