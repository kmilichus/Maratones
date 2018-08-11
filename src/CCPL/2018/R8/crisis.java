import java.io.*;
import java.util.LinkedList;

public class crisis {
	
	static int[] ans = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 18, 10, 11, 7, 17, 11, 15, 29, 5, 21, 13, 26, 14, 11, 23, 22, 9, 73, 17, 42, 7, 98, 15, 61, 22, 84, 24, 30, 9, 38, 15, 54, 27, 9, 61, 38, 22, 19, 178, 38, 53, 79, 68, 166, 20, 9, 22, 7, 21, 72, 133, 41, 10, 82, 92, 64, 129, 86, 73, 67, 19, 66, 115, 52, 24, 22, 176, 10, 57, 137, 239, 41, 70, 60, 116, 81, 79, 55, 102, 49, 5, 22, 54, 52, 113, 15, 66, 206, 193, 8, 69, 100, 15, 18, 11, 44, 103, 52, 26, 102, 236, 87, 21, 140, 17, 45, 33, 72, 69, 106, 75, 36, 48, 91, 185, 187, 183, 103, 9, 58, 129, 154, 10, 48, 303, 204, 157, 72, 288, 160, 105, 296, 169, 72, 212, 183, 299, 84, 28, 152, 78, 510, 157, 282, 78, 157, 582, 261, 251, 367, 205, 558, 284, 101, 33, 115, 359, 15, 616, 11, 87, 488, 51, 92, 124, 101, 81, 53, 13, 278, 313, 263, 345, 25, 53, 132, 96, 92, 137, 44, 56, 453, 16, 134, 139, 127, 64, 327, 453, 28, 7, 333, 461, 127, 262, 11, 52, 82, 217, 190, 83, 132, 58, 20, 474, 139, 25, 291, 42, 51, 71, 15, 165, 8, 231, 363, 177, 404, 883, 46, 64, 148, 80, 68, 125, 192, 608, 15, 177, 892, 234, 56, 241, 179, 54, 683, 258, 797, 287, 222, 107, 490, 277, 631, 331, 483, 155, 145, 125, 41, 72, 691, 44, 258, 199, 373, 151, 13, 298, 255, 427, 348, 210, 437, 172, 199, 121, 112, 167, 938, 210, 980, 610, 39, 56, 132, 102, 342, 109, 421, 51, 183, 212, 268, 37, 277, 1580, 358, 508, 754, 835, 99, 154, 586, 253, 845, 154, 168, 23, 358, 69, 89, 385, 133, 513, 353, 620, 275, 115, 65, 57, 640, 385, 55, 494, 202, 278, 495, 76, 339, 926, 573, 77, 347, 198, 275, 31, 96, 149, 772, 202, 623, 90, 133, 193, 256, 268, 1959, 577, 500, 77, 248, 301, 1310, 347, 193, 78, 660, 315, 575, 438, 1100, 920, 115, 224, 11, 479, 100, 217, 63, 81, 430, 7, 367, 936, 63, 952, 438, 338, 163, 56, 231, 638, 1141, 334, 71, 41, 1238, 277, 137, 17, 456, 386, 403, 1174, 974, 846, 255, 100, 644, 63, 142, 878, 23, 127, 90, 403, 594, 19, 81, 155, 257, 335, 1338, 1033, 388, 218, 183, 215, 535, 1758, 2476, 553, 1083, 454, 766, 1567, 776, 89, 101, 1438, 148, 45, 5, 215, 26, 100, 563, 80, 1040, 792, 150, 543, 65, 221, 712, 76, 1291, 69, 246, 150, 72, 45, 79, 154, 249, 40, 773, 339, 1187, 143, 137, 205, 705, 53, 159, 1211, 255, 66, 349, 94, 41, 873, 444, 502, 364, 1010, 208, 340, 44, 159, 1685, 23, 79, 1270, 556, 204, 525, 189, 764, 664, 3324, 334, 77, 21, 41, 90, 643, 1374, 745, 34, 93, 906, 1687, 229, 1347, 1059, 7, 1362, 613, 16, 705, 361, 84, 558, 537, 362, 295, 49, 54, 404, 1272, 408, 502, 1825, 2000, 368, 311, 821, 981, 59, 1757, 355, 221, 1955, 648, 117, 1537, 571, 330, 495, 476, 43, 692, 105, 1579, 937, 552, 229, 1584, 119, 178, 355, 657, 701, 620, 191, 399, 241, 1050, 1077, 112, 99, 221, 375, 82, 830, 597, 2248, 119, 31, 8, 144, 376, 817, 857, 982, 667, 1342, 606, 158, 420, 232, 917, 845, 1120, 472, 33, 229, 534, 723, 71, 404, 303, 309, 1031, 138};


	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

//		System.out.println(Arrays.toString(findAll()));

		int N = Integer.parseInt(in.readLine());

		while (N!=0) {


			out.write(ans[N]+"\n");

			N = Integer.parseInt(in.readLine());
		}


		in.close();
		out.close();


	}

	private static int[] findAll() {

		int[] values = new int[601];

		for (int i = 13; i < values.length; i++) {

			values[i]= locate(i);

		}


		return values;
	}

	private static int locate(int i) {

		boolean found = false;
		int m = 0;
		for (; !found; ) {
			m++;
			LinkedList<Integer> lista = inicializarLista(i);			
			found = buscar(lista, m);
		}


		return m;

	}

	private static boolean buscar(LinkedList<Integer> lista, int m) {
		
		boolean found = false;
//		lista.remove(0);
		int index = 0;
		
		while(!lista.isEmpty() && !found){
			
		
			
			int i = index%lista.size();
			if(lista.get(i)==13){				
				if(lista.size()!=1){
					found = true;
					
				}
				
			}
//			System.out.println("m: "+m);
//			System.out.println("indice ->"+i);
//			System.out.println("borre -> "+ lista.get(i));
//			
			lista.remove(i);
			
//			System.out.println(lista);
		
			index = i;
			index+=m;
			index--;
		}

		return !found;
	}

	private static LinkedList<Integer> inicializarLista(int i) {

		LinkedList<Integer> lista = new LinkedList<Integer>();

		for (int j = 0; j < i; j++) {
			lista.add(j+1);
		}
		return lista;
	}




}