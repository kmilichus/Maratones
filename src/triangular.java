import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class triangular {

	
	public static void main(String[] args) throws IOException {
		
		//Scanner in = new Scanner(System.in);
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	    double caso = Double.parseDouble(in.readLine());
	    double res;
	    
	    //pruebas
	    //  double x= 518452;
	    //    System.out.println((x*(x+1))/2);
	     
	   	while(caso!=0){
	   		res = Math.sqrt((8*caso)+1);
	   			if((res-(int)res)!=0)
	   				out.write("NO\n");
	   			else
	   				out.write("SI\n");
	   			
	   		caso = Double.parseDouble(in.readLine());
	   		res=0;
	   		
		}
		 out.flush();
	     out.close();
	     in.close();
	   }

}
