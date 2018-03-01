
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class comando {
	
	
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
			
			int acumulado=0;
			
			int tiempoTotal=0;
			int temporal=0;
			while(!cola.isEmpty()) {
				soldier actual=cola.poll();
				temporal=0;
				if(acumulado<actual.brief) {
					tiempoTotal+=actual.brief-acumulado;
					if(acumulado!=0) {
						acumulado=actual.brief-acumulado;
					}
				}else {
					acumulado-=actual.brief;
				}
				
				if(acumulado<actual.mision) {
					tiempoTotal+=actual.mision-acumulado;
					acumulado+=actual.mision-acumulado;
				}else {
					
				}
				acumulado+=temporal;
			}
			
			out.write("Case "+index+": "+tiempoTotal+"\n");
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
			// TODO Auto-generated method stub
//			return o.total-total;
			if(mision==o.mision) {
				return brief-o.brief;
			}else {
				return o.mision-mision;
			}
		}
		
		
	}
}
