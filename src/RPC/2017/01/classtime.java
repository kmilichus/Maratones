import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class classtime {

	
	public static int espacioVacio(String dato)
	{
		int n=0;
		char[] letras = dato.toCharArray();
		for(int i=0;i<letras.length;i++)
		{
			if(letras[i]==32){
				n=i;
			}
		}
		
		return n+1;
	}
	
	

	
	public static void main(String[] arg1) throws IOException {

		

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
	
		int a = Integer.parseInt(lector.readLine());
		
		String[] args = new String[a];
		
		for(int z=0; z<args.length;z++)
		{
			args[z] = lector.readLine();
		}
		
		String[] nombres= new String[args.length];
		String[] apellidos = new String[args.length];
		
		
		for(int i=0; i<args.length;i++)
		{
			nombres[i] = args[i].substring(0, espacioVacio(args[i])-1);
			apellidos[i]=args[i].substring(espacioVacio(args[i]),args[i].length());
		}
		
		
		for(int j=0; j<args.length;j++)
		{
			args[j]=apellidos[j]+" "+nombres[j];
		}
		
		Arrays.sort(args);
		
		for(int i=0; i<args.length;i++)
		{
			
			nombres[i] =args[i].substring(espacioVacio(args[i]),args[i].length());
			apellidos[i]= args[i].substring(0, espacioVacio(args[i])-1);
			
		}
		
		
		
		for(int i=0;i<args.length;i++)
		{
			args[i] = nombres[i]+" "+apellidos[i];
		}
		
		
		
		for(int k=0; k<args.length;k++){
			System.out.println(args[k]);

		}
	


		
		
		
		
		
		
		
		
		
	}

}
