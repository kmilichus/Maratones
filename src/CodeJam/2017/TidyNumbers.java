import java.io.*;

public class TidyNumbers {
	
	static String[] letters;

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader (System.in) );
		BufferedWriter out = new BufferedWriter (new OutputStreamWriter(System.out));
		
		
		int T = Integer.parseInt(in.readLine());
		String linea = in.readLine();
		int casos = 1;
		
		while (T-->0) {
	
			String ans = "";
			out.write("Case #"+casos+": ");
			int flip = -1;
			
			if (linea.length()==1) {
				ans = linea;
			}else {
				
				boolean tidy = true;
				
				char[] letras = linea.toCharArray();
				
				for (int i = 0; i+1 < letras.length && tidy; i++) {
					
					if (letras[i]>letras[i+1]) {
						flip = i;
						tidy =false;
					}
				}
				
				if (tidy) {
					ans = linea;
				}else {
					
					boolean diferente = false;
						
						
					for (int i = flip; i > 0 && !diferente ; i--) {
						
						if (letras[i]!=letras[i-1]) {
							
							flip = i;
							letras[i]--;
							diferente = true;							
							
						}
						
					}
				
				if (!diferente) {					
					flip = 0;
					letras[0]--;
					
				}
				
				flip++;

				for (int i = flip; i < letras.length; i++) 
					letras[i]='9';
				
	
				StringBuilder sb = new StringBuilder();
				
				for (int i = 0; i < letras.length; i++){
					
					if (i==0 && letras[i]=='0') {
						
					}else {						
						sb.append(letras[i]+"");
					}
				} 
				
				ans = sb.toString();
				
				}
				
				
			}
			
			
			
			
			
			
			
			out.write(ans+"\n");
			casos++;
			linea = in.readLine();
		}

		
		in.close();
		out.close();;
		
		
	}

	

}
