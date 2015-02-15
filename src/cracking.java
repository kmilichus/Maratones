import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class cracking {

	//	public static char[] traductorEncripta;
	public static char[] traductorDesencripta;

	public static void main(String[] args) throws Exception { 

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 


		int casos = Integer.parseInt(in.readLine());

		while (casos>0) {

			inicializarTraductor();
			int msjEnc = Integer.parseInt(in.readLine());
			String[] encriptadas = new String[msjEnc];
			ArrayList<String> posibilidades = new ArrayList<String>();

			for (int i = 0; i < msjEnc ; i++) {	
				encriptadas[i]=in.readLine();			
			}

			String mensaje = in.readLine();

			String decode = in.readLine();

			boolean encajo = false;
			for (int i = 0; i < encriptadas.length; i++) {
				String temporal = encriptadas[i];

				if (match(mensaje, temporal)) {
					encajo=true;
					// pruebas
//					System.out.println("El caso "+casos+" encajo con la palabra " + temporal );
//					System.out.println("Traductor: ");
//
//					for (int j = 0; j < traductorDesencripta.length; j++) {
//						if (traductorDesencripta[j]!= 'A') {
//							System.out.println((char)(j+97)+" --> "+ traductorDesencripta[j]);							
//						}
//
//					}
//					System.out.println();
					// fin pruebas

					faltaUnaLetra();

					posibilidades.add(imprimir(decode.toCharArray()));
				}
				inicializarTraductor();

			}

			if (!encajo) {
				out.write("IMPOSSIBLE");
			}else {
				//imprime bien
				if (posibilidades.size()==1) {
					out.write(posibilidades.get(0));
				}else {
					out.write(merge(posibilidades));
				}
			}

			out.write("\n");			

			casos--;

		}


		out.flush();
		out.close(); 
		in.close(); 

	}

	private static String merge(ArrayList<String> posibilidades) {

		StringBuilder retorno = new StringBuilder();
		char[] respuesta =posibilidades.get(0).toCharArray();

		for (int i = 1; i < posibilidades.size(); i++) {

			char[] temporal = posibilidades.get(i).toCharArray();
			for (int j = 0; j < temporal.length; j++) {
				
				if (respuesta[j] != temporal[j]) {
					respuesta[j]='?';
				}
				
			}
		}

		for (int i = 0; i < respuesta.length; i++) {
			retorno.append(""+respuesta[i]);
		}
		
		return retorno.toString();
	}

	private static String imprimir(char[] decode) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < decode.length; i++) {
			int pos = decode[i]-97;
			if (traductorDesencripta[pos]=='A') {
				sb.append("?");
			}else {
				sb.append(""+traductorDesencripta[pos]);
			}
		}

		return sb.toString();
	}

	private static void faltaUnaLetra() {
		int faltantes = 0;
		int lugar = 0;
		boolean[] esta = new boolean[26]; 

		for (int i = 0; i < traductorDesencripta.length && faltantes<2; i++) {
			if (traductorDesencripta[i]=='A') {
				faltantes++;
				lugar = i;
			}else {
				esta[traductorDesencripta[i]-97]=true;				
			}
		}

		if (faltantes==1) {
			boolean completo = false;
			
			for (int i = 0; i < esta.length && !completo; i++) {
				if (!esta[i]) {
					char x = (char) (i+97);
					traductorDesencripta[lugar]=x;
					completo=true;
				}
			}
		}

	}

	static void inicializarTraductor() {
		traductorDesencripta = new char[26];
		//		traductorEncripta = new char[26];
		for (int i = 0; i < 26; i++) {
			traductorDesencripta[i]='A';
			//			traductorEncripta[i]='A';
		}


	}

	static boolean match(String mensaje, String encriptado) {
		boolean match = true;

		if (mensaje.length() == encriptado.length()) {

			char[] desencriptado1 = mensaje.toCharArray();
			char[] encriptado1 = encriptado.toCharArray();
			//
			//
			//			for (int i = 0; i < encriptado1.length; i++) {
			//				char letraEncripta = encriptado1[i];
			//				char letraDesencripta = desencriptado1[i];
			//
			//				if (traductorDesencripta[letraEncripta-97]=='A' && traductorEncripta[letraDesencripta-97]=='A') {
			//					traductorDesencripta[letraEncripta-97]= letraDesencripta;
			//					traductorEncripta[letraDesencripta-97]= letraEncripta;
			//				}else {
			//					if (traductorDesencripta[letraEncripta-97]!='A' && traductorEncripta[letraDesencripta-97]!= traductorDesencripta[letraEncripta-97]) {
			//						match=false;
			//					}else {
			////						if (traductorEncripta[letraDesencripta-97]!='A' && traductorDesencripta[letraEncripta-97] != traductorEncripta[letraDesencripta-97]) {
			////							match =false;
			////						}
			//
			//					}
			//				}
			//			}

			boolean[] existe = new boolean[26];
			for (int i = 0; i < encriptado1.length && match; i++) {

				int posTraducctor = encriptado1[i]-97;

				if (traductorDesencripta[posTraducctor]=='A') {
					if (existe[desencriptado1[i]-97]) {
						match=false;
					}else {
						traductorDesencripta[posTraducctor]= desencriptado1[i];
						existe[desencriptado1[i]-97] = true;

					}

				}else {
					if (traductorDesencripta[posTraducctor]!=desencriptado1[i]) {
						match = false;
					}


				}
			}

		}else {
			match=false;
		}



		return match;
	}
}
