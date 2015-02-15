import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class IsThisTheEasiestProblem {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		long x,y,z;
		int n;
		n= in.nextInt();
		for(int i=1;i<n+1;i++){
			x= in.nextLong();
			y= in.nextLong();
			z= in.nextLong();
			if(x>=y+z || y>=x+z || z>=x+y || x<1 ||y<1 ||z<1){
				out.write("Case "+i+": Invalid\n");
			}
			else if(x==y && y==z){
				out.write("Case "+i+": Equilateral\n");
			}
			else if(x==y || y==z || x==z){
				out.write("Case "+i+": Isosceles\n");
			}else{
				out.write("Case "+i+": Scalene\n");

			}
		}
		out.flush();
		out.close();

	}

}
