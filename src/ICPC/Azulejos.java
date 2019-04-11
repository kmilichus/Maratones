import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Azulejos {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
		
		
		StringTokenizer stk1 = new StringTokenizer(in.readLine());
		StringTokenizer stk2 = new StringTokenizer(in.readLine());
		
		PriorityQueue<Tile> back = new PriorityQueue<Tile>();
		TreeMap<Tile, Integer> front = new TreeMap<>(); 
		LinkedList<Tile> ansBack = new LinkedList<>();
		LinkedList<Tile> ansFront = new LinkedList<>();

		for (int i = 0; i < n; i++) {	
			Tile t = new Tile(Integer.parseInt(stk1.nextToken()), Integer.parseInt(stk2.nextToken()), i+1);
			back.add(t);
		}
		
		stk1 = new StringTokenizer(in.readLine());
		stk2 = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < n; i++) {	
			Tile t = new Tile(Integer.parseInt(stk1.nextToken()), Integer.parseInt(stk2.nextToken()), i+1);
			front.put(t, 1);
		}
		
		System.out.println(back);
//		System.out.println(front);
		
		
		
		
		
		in.close();
		out.close();
		
		
	}
	
	public static class Tile implements Comparable<Tile>{
		
		Integer price;
		
		Integer size;
		
		Integer id;

		public Tile(int price, int size, int id) {
			this.price = price;
			this.size = size;
			this.id = id;
		}
		
		
		public String toString() {
			return "id: "+id + " p: "+price + " s: "+size;
//			return ""+id;
		}


		@Override
		public int compareTo(Tile t) {
			
			int r = price.compareTo(t.price);
			
			if(r==0) {
				r = size.compareTo(t.size);
				if(r==0) {
					r = id.compareTo(t.id);
					
				}
			}
			return r;	
		}
		
		
	}

}
