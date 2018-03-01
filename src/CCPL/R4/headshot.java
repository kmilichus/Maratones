import java.io.*;

public class headshot {

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader (System.in) );
		BufferedWriter out = new BufferedWriter (new OutputStreamWriter(System.out));


		String line = in.readLine();

		while (line!=null) {

			char[] bullets = line.toCharArray();

			double loaded = 0;
			double empty = 0;
			double emptyNearBy = 0;


			for (int i = 0; i < bullets.length; i++) {

				if (bullets[i]=='1') {
					loaded++;
				}else {
					empty++;
					if (i==bullets.length-1) {
						if (bullets[0]=='0') 
							emptyNearBy++;
					} else {
						if (bullets[i+1]=='0')
							emptyNearBy++;
					}
				}
			}

			double pShoot = 0;

			if (emptyNearBy!=0) 
				pShoot = emptyNearBy/empty;				



			double pRotate = empty/(empty+loaded);

			
			
			
			if (pShoot>pRotate) {
				out.write("SHOOT\n");
			}else if (pRotate>pShoot) {
				out.write("ROTATE\n");
			}else {
				out.write("EQUAL\n");
			}

			line = in.readLine();
		}




		out.close();
		in.close();

	}

}
