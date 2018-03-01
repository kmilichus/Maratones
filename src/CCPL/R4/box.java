import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class box {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String D = br.readLine();
		while(D!=null){
			int Dnum = Integer.parseInt(D);
			int Rnum = Integer.parseInt(br.readLine());
			int Tnum = Integer.parseInt(br.readLine());
			
			double r = (2*Dnum-2)+Math.sqrt(Math.pow(2*Dnum-2, 2)-8*(Math.pow(Dnum, 2)-Dnum-2*(9+Rnum+Tnum)));
			r = (r/4);
			double t = r-Dnum;
			
			double cr =2*(Rnum-Tnum)-(Dnum*(1+t+r))+6;
			cr = (cr/4);
			int answer = (int)cr;
			bw.write(answer+"\n");
			D=  br.readLine();
		}
		
		br.close();
		bw.close();
	}

}
