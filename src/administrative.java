import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class administrative {

	public static void main(String[] args) throws Exception { 

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 


		int casos = Integer.parseInt(in.readLine());
		int tipocarros, eventos;
		StringTokenizer stk;
		HashMap<String, Car> carros;
		TreeMap<String, Espia> espias;


		while (casos >0) {

			stk = new StringTokenizer(in.readLine());
			carros = new HashMap<String,Car>();
			espias = new TreeMap<String, Espia>();
			tipocarros = Integer.parseInt(stk.nextToken());
			eventos = Integer.parseInt(stk.nextToken());

			for (int i = 0; i < tipocarros; i++) {

				stk = new StringTokenizer(in.readLine());

				String n = stk.nextToken();
				double p = Double.parseDouble(stk.nextToken());
				int pc = Integer.parseInt(stk.nextToken());
				int co = Integer.parseInt(stk.nextToken());

				Car c = new Car(n, p, pc, co);
				carros.put(n,c);
			}


			for (int i = 0; i < eventos; i++) {
				stk = new StringTokenizer(in.readLine());
				int hora= Integer.parseInt(stk.nextToken());
				String espia = stk.nextToken();
				char accion = stk.nextToken().charAt(0);
				String valor = stk.nextToken();
				Espia actual = espias.get(espia);
	
				if (actual== null){
					actual =new Espia(0, espia, false, false);
				}
				switch (accion) {

				case 'p':
					Car carro = carros.get(valor);
					if (!actual.afuera) {						
					actual.afuera = true;
					actual.elCarro = carro;
					actual.xPagar += carro.pickUpCost;
					
					}else {
						actual.inconsistente = true;
					}
					
					break;

				case 'r':
					actual.afuera = false;
					carro = actual.elCarro;
					if (carro!=null) {
						actual.xPagar += Integer.parseInt(valor)*carro.costoxKm;
						actual.elCarro=null;						
					} else {
						actual.inconsistente=true;
					}
					
					break;

				case 'a':
					actual.afuera = true;
					carro = actual.elCarro;
					if (carro != null) {	
						double porcentaje =100;
						int reparacion = (int) Math.ceil(carro.precio*(Double.parseDouble(valor))/porcentaje);
						actual.xPagar += reparacion;
					}
					else {
						actual.inconsistente=true;
					}

					break;

				}	

				espias.put(actual.nombre, actual);


			}

			out.write(imprimir(espias));

			casos --;

		}

		out.flush();
		out.close(); 
		in.close(); 

		System.exit(0);

	}


	public static class Car{

		public String nombre;
		public double precio;
		public int pickUpCost;
		public int costoxKm;

		public Car(String nombre, double precio, int pickUpCost, int costoxKm) {

			this.nombre = nombre;
			this.precio = precio;
			this.pickUpCost = pickUpCost;
			this.costoxKm = costoxKm;
		}

		@Override
		public boolean equals(Object obj) {
			boolean igual= false;
			if (obj instanceof Car){
				Car x = (Car) obj;
				igual = nombre.equals(x.nombre);
			}

			return igual;
		}

		public boolean mismoNombre(String nombre){

			return nombre.equals(this.nombre);
		}



	}

	public static class Espia implements Comparable{

		public int xPagar;
		public String nombre;
		public boolean afuera;
		public boolean inconsistente;
		public Car elCarro;

		public Espia(int xPagar, String nombre, boolean afuera, boolean inconsistente) {

			this.xPagar = xPagar;
			this.nombre = nombre;
			this.afuera = afuera;
			this.inconsistente = inconsistente;
			elCarro=null;
		}

		@Override
		public int compareTo(Object o) {

			if(o instanceof Espia){

				Espia x = (Espia)o;
				int yy =this.nombre.compareTo(x.nombre);
				return yy;
			}

			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			boolean igual= false;
			if (obj instanceof Espia){
				Espia x = (Espia) obj;
				igual = nombre.equals(x.nombre);
			}

			return igual;
		}


		public boolean mismoNombre(String nombre){

			return nombre.equals(this.nombre);
		}



	}


	private static String imprimir(TreeMap<String, Espia> espias) {

		StringBuilder res = new StringBuilder();
		Iterator it = espias.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();
			Espia x = (Espia) pairs.getValue();
			res.append(x.nombre+" ");

			if (x.inconsistente) {
				res.append("INCONSISTENT\n");
			}else {
				if (x.afuera) 
					res.append("INCONSISTENT\n");
				else 
					res.append(x.xPagar+"\n");
			}


		}
		return res.toString();

	}


//	public static Car buscarCarro(LinkedList<Car> carros, String valor) {
//		Car x = null;
//		
//		outer:
//		for (int i = 0; i < carros.size(); i++) {
//			Car y = carros.get(i);
//			if(y.mismoNombre(valor)){
//				x = y;
//				break outer;
//			}
//
//		}
//
//		return x;
//	}


//	public static Espia espiaExiste(TreeMap<Espia,Integer> espias, String espia) {
//
//		Espia existe = null;
//
//		Iterator it = espias.entrySet().iterator();
//		outer:
//		while (it.hasNext() ) {
//			Map.Entry pairs = (Map.Entry)it.next();
//			Espia x = (Espia) pairs.getKey();
//			if (x.mismoNombre(espia)) {
//				existe = x;
//				break outer;
//			}
//		}
//
//		return existe;
//	}









}
