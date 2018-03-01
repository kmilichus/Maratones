import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class commando {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter( new OutputStreamWriter(System.out));
		int number=Integer.parseInt(in.readLine().trim());
		int index=1;
		while(number!=0) {
			PriorityQueue<soldier> cola=new PriorityQueue();
			for (int i = 0; i < number; i++) {
				
				StringTokenizer skt=new StringTokenizer(in.readLine());
				cola.add(new soldier(Integer.parseInt(skt.nextToken()), Integer.parseInt(skt.nextToken())));
			}
			
			
			
			int maxTime = 0;
			int tinicio = 0;
			while(!cola.isEmpty()) {
				soldier actual=cola.poll();
				int tfinal = tinicio + actual.total;
				maxTime = Math.max(maxTime, tfinal);
				tinicio = actual.brief+tinicio;
			}
			out.write("Case "+index+": "+maxTime+"\n");
			index++;
			number=Integer.parseInt(in.readLine().trim());
		}
		out.close();
	}
	
	
	static class soldier implements Comparable<soldier>{
		int brief;
		int mision;
		int total;
		public soldier(int brief, int mision) {
			this.brief = brief;
			this.mision = mision;
			total=brief+mision;
		}
		@Override
		public int compareTo(soldier o) {
				return o.mision-mision;
		}
		
		
	}
}
