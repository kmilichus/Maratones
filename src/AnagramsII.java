
import java.io.*;
import java.util.*;


public class AnagramsII {

	public static class Anagrama implements Comparable {

		public LinkedList<String> anagramas;

		public Anagrama(String anagrama) {
			anagramas = new LinkedList<String>();
			anagramas.add(anagrama);
		}

		@Override
		public int compareTo(Object o) {
			return ((Anagrama)o).anagramas.size() - anagramas.size();
		}

		public void add(String pal) {
			if(!anagramas.getLast().equals(pal)) {
				anagramas.add(pal);
			}
		}

		@Override
		public String toString() {
			String respuesta = "Group of size "+anagramas.size() + ": ";
			Iterator<String> it = anagramas.iterator();
			while(it.hasNext()) {
				respuesta += it.next() + " ";
			}
			return respuesta + ".\n";
		}

	}

	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line;
		int casos, tamaño;
		ArrayList<char[]> diccionario = new ArrayList<char[]>();
		ArrayList<String> palabras = new ArrayList<String>();
		casos = Integer.parseInt(in.readLine());
		line = in.readLine();
		while (casos>0) {
			tamaño =  Integer.parseInt(in.readLine());
			while(tamaño>0) {
				line = in.readLine();
				if(line == null || line.isEmpty())
					palabras.add(line);
				tamaño--;
			}

			Collections.sort(palabras);
			for (int i = 0; i < palabras.size(); i++) {
				diccionario.add(palabras.get(i).toCharArray());
				Arrays.sort(diccionario.get(diccionario.size()-1));
			}

			char[] palabraA, palabraB;
			ArrayList<Anagrama> respuestas = new ArrayList<Anagrama>();

			for (int i = 0; i < diccionario.size(); i++) {
				respuestas.add(new Anagrama(palabras.get(i)));
				for (int j = i+1; j < diccionario.size(); j++) {
					palabraA = diccionario.get(i);
					palabraB = diccionario.get(j);
					if(palabraA.length == palabraB.length) {
						boolean anagrama = true;
						for (int k = 0; k < palabraA.length; k++) {
							if(palabraA[k] != palabraB[k]) {
								anagrama = false;
								break;
							}
						}
						if(anagrama) {
							respuestas.get(respuestas.size()-1).add(palabras.get(j));
							palabras.remove(j);
							diccionario.remove(j);
							j --;
						}
					}
				}
			}

			Collections.sort(respuestas);
			for (int i = 0; i < 5 && i < respuestas.size(); i++) {
				out.write(respuestas.get(i).toString());
			}
			casos--;
		}
		in.close();
		out.flush();
		out.close();

	}

}
