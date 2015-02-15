
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BackToHighSchoolPhysics {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int velocidad=0;
		int tiempo=0;
		
		while (true) {
			try {
				velocidad = in.nextInt();
			} catch (Exception e) {
				break;
			}
			 tiempo = in.nextInt();

			out.write(2*velocidad*tiempo+"\n");

		}
		
		in.close();
		out.flush();
		out.close();
	}
}

