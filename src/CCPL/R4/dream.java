import java.io.*;

public class dream {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();

		while (line != null) {

			int sequence = 0, ones = 0;

			boolean ok = false;


			char[] letters = line.toCharArray();

			for (int i = 0; i < letters.length; i++) {

				char current = letters[i];

				if (current == '0' || current == '?') {
					if (ones > 0) {
						if (ones == 1) {
							ok = true;
						}
						ones--;
					} else {
						sequence++;
						ok = false;
					}
				} else
					ones++;
			}


			if (ok || ones > 0 ){
				out.write("0\n");
			}
			else{
				out.write(sequence+"\n");
			}

			line = in.readLine();

		}

		out.close();
		in.close();

	}

}
