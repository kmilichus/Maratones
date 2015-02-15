
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class prueba {

	public static void main(String[] args) throws IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer("");
		String palabra, respuesta;
		ArrayList<String> encontradas=new ArrayList<String>();
		respuesta = "";

		while((palabra=lector.readLine())!=null){
			palabra= quitarEspacios(palabra);
			encontradas.clear();
			StringBuilder temp=new StringBuilder("");
			String temporal= "";

			for(int i=0;i<palabra.length();i++){
				temporal = palabra.charAt(i)+"";
				if(palindromo(temporal)){
					if(!encontradas.contains(temporal)){
						encontradas.add(temporal);
					}
				}
				for(int j=i+1;j<palabra.length();j++){
					temporal+= palabra.charAt(j);
						if(palindromo(temporal)){
							if(!encontradas.contains(temporal)){
								encontradas.add(temporal);
						}
					}
				}
			}
			respuesta+= "The string '"+palabra+"' contains "+encontradas.size()+" palindromes.\n";
		}
		System.out.print(respuesta);
	}

	private static String quitarEspacios(String line) {
		String linea = "";
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i)!= ' '){
				linea += line.charAt(i);
			}
		}
		return linea.toLowerCase();

	}

	private static boolean palindromo(String linea) {
		boolean flag = true;
		for (int i = 0, j = linea.length() - 1; i < linea.length() / 2; i++, j--) {
			if (linea.charAt(i) != linea.charAt(j)) {
				flag=false;;
			}
		}
		return flag;
	}


}