import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HashmatTheBraveWarrior {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		while(in.hasNext()){
			long v=in.nextLong();
			long t=in.nextLong();
			out.write(Math.abs(t-v)+"\n");
		}
		out.flush();
		out.close();
		in.close();

	}
}