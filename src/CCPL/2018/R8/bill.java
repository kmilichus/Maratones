import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class bill {



	public static TreeMap<Long, Integer> priceToWatts;
	public static TreeMap<Integer, Long> WattsToPrice;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();

		//		populate();
		
//		System.out.println(findPrice(100));
//		System.out.println(findPrice(10000));
//		System.out.println(findPrice(1000000));

		while (!line.equals("0 0")) {

			String[] arr = line.split(" ");

			int A = Integer.parseInt(arr[0]); //Lo que se pago

			int B = Integer.parseInt(arr[1]); //la diferencia en lo que se paga

			// x + y  = A   A-y = x		
			// precio(x) - precio(y) = B

			int max = (int) findWatts(A);

			out.write(search(0, max, max, A, B)+"\n");



			line = in.readLine();
		}


		in.close();
		out.close();


	}




	private static void populate() {

		priceToWatts = new TreeMap<>();
		WattsToPrice = new TreeMap<>();
		for (int i = 0; i < 1000000000; i++) {

			long price = findPrice(i);
			priceToWatts.put(price, i);
			WattsToPrice.put(i, price);

		}


	}




	public static int search(int low, int top, int max, int A, int B){

		int consumo = (low + top) / 2;
		int vecino = max -consumo ;

		long diferencia = Math.abs(findPrice(consumo) - findPrice(vecino));

//		System.out.println( consumo + " | "+ vecino +" | "+ diferencia);

		if(diferencia == B){
			return (int) findPrice(Math.min(consumo, vecino));
		}else if (diferencia < B){
			low = consumo;
			return search(low, top, max, A, B);
		}else{
			top = consumo;
			return search(low, top, max, A, B);
		}

		//	return -1;
	}


	public static long findPrice(int watts){

		long price = 0l;


		if(watts<= 100){
			price  = watts * 2l;
		}else if (watts <= 10000l){
			price  = 100l * 2l + (watts-100l)*3l;
		}else if (watts <= 1000000l){
			price  = 100l * 2l + 9900l*3l +(watts-10000l)*5l;
		}else {
			price  = 100l * 2l + 9900l*3l + 990000l*5l+(watts-1000000l)*7l;
		}


		return price;
	}

	public static long findWatts(int p){

		long consumo = 0l;


		if(p<= 200){
			consumo  = p / 2l;
		}else if (p <= 29900l){
			consumo  = 100 + (p-200l)/3l;
		}else if (p <= 4950000l){
			consumo  = 10000 +(p-29900l)/5l;
		}else {
			consumo  = 1000000 +(p-4979900l)/7l;
		}


		return consumo;
	}



}
