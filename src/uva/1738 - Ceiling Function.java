
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ceiling {


	public static void main(String[] args) throws IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


		String linea = in.readLine();


		while (linea != null) {

			StringTokenizer stk = new StringTokenizer(linea);

			int N = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());

			LinkedList<Nodo> nodos = new LinkedList<Nodo>();

			for (int i = 0; i < N; i++) {			
				stk = new StringTokenizer(in.readLine());
				Nodo bst = new Nodo(Integer.parseInt(stk.nextToken()));

				while(stk.hasMoreTokens()){
					bst =insertarBST(bst, Integer.parseInt(stk.nextToken()));
				}

				boolean igual = false;
				for (int j = 0; j < nodos.size() && !igual; j++) {

					if(igualesEnForma(bst, nodos.get(j))){
						igual = true;
					}
				}

				if(!igual){
					nodos.add(bst);
				}
			}

//			System.out.println(nodos.toString());
			out.write(nodos.size()+"\n");

			linea = in.readLine();
		}


		in.close();
		out.close();
	}


	static class Nodo{
		public int valor;
		Nodo izq;
		Nodo der;

		public Nodo(int value){
			valor = value;
		}

		@Override
		public String toString() {
			return valor+"";
		}

	}

	public static Nodo insertarBST(Nodo raiz, int valor) {

		//Caso Base
		if (raiz == null) {
			raiz = new Nodo(valor);
			return raiz;
		}

		//Caso Recursivo
		if (valor < raiz.valor)
			raiz.izq = insertarBST(raiz.izq, valor);
		else if (valor > raiz.valor)
			raiz.der = insertarBST(raiz.der, valor);

		return raiz;
	}
	
	static boolean igualesEnForma(Nodo BST1, Nodo BST2){
		if (BST1 == null && BST2 == null)
			return true;

		if ((BST1 == null && BST2 != null) || (BST1 != null && BST2 == null))
			return false;

		return igualesEnForma(BST1.izq, BST2.izq) && igualesEnForma(BST1.der, BST2.der);
	}





}
