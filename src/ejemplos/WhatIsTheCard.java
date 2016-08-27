import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class WhatIsTheCard {

	/**
	 * Camilo Barrios
	 * Uva 10646 - What is the Card?
	 * AC
	 */

	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();
		int veces = Integer.parseInt(linea);
		int caso = 1;

		while (veces-->0) {

			Stack<String> top = new Stack<String>();
			StringTokenizer stk = new StringTokenizer(in.readLine());
			LinkedList<String> bot = new LinkedList<String>();


			for (int i = 0; i < 50; i++) {
				if (i< 27) 
					top.add(stk.nextToken());
				else{
//					if (i==28) 
//						stk = new StringTokenizer(in.readLine());					
					bot.add(stk.nextToken());
				}
			}


			int acumulado = 0;
			int proceso = 3;
			while (proceso-->0) {				
				int X = encontrarValor(top.pop());	
				acumulado+=X;
				int times = 10-X;
				while(times-->0){
					top.pop();
				}

			}

			while (!bot.isEmpty()) 
				top.add(bot.pop());


			out.write("Case "+caso+": "+top.elementAt(--acumulado)+"\n");
			caso++;

		}
		in.close();
		out.close();
	}


	private static int encontrarValor(String cadena) {

		char letra = cadena.charAt(0);
		int valor = 10;

		switch (letra) {
		case '2':
			valor = 2;
			break;
		case '3':
			valor = 3;
			break;
		case '4':
			valor = 4;
			break;
		case '5':
			valor = 5;
			break;
		case '6':
			valor = 6;
			break;
		case '7':
			valor = 7;
			break;
		case '8':
			valor = 8;
			break;
		case '9':
			valor = 9;
			break;
		}

		return valor;
	}





}