import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class gianik {

	static int currentRound = 0;

	public static void main(String args[]) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea = in.readLine();


		while (linea!=null) {


			int n = Integer.parseInt(linea);

			Planeta[] planetas = new Planeta[n];
			StringTokenizer stk;
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(in.readLine());
				int p = Integer.parseInt(stk.nextToken());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				planetas[i] = new Planeta(p,a,b);
			}

			int[] angulosUsados = new int[360];
			Arrays.fill(angulosUsados, -1);


			boolean eclipse = false;
			outer:
				for (int t = 0; t <= 721; t++) {
					for (Planeta planeta : planetas) {
						int pos = planeta.pos(t);
						pos %= 360;
						pos += 360;
						pos %= 360;
						int currentB = angulosUsados[pos];
						if (currentRound == currentB) {
							out.write(t+"\n");
							eclipse = true;
							break outer;
						}
						angulosUsados[pos] = currentRound;
					}
					currentRound++;
				}
			if (!eclipse) {
				out.write("GIANIK IS NEVER ECLIPSED\n");
			}
			linea = in.readLine();
		}

		out.close();
		in.close();

	}

	static class Planeta {
		int p, a, b;


		public Planeta(int p, int a, int b) {
			this.p = p;
			this.a = a;
			this.b = b;
		}


		int pos(int time) {
			return a + b * time;
		}
	}




}
