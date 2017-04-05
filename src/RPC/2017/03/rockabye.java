import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class rockabye {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int T = Integer.parseInt(in.readLine());
		
		PriorityQueue<Medicine> cola;
		StringTokenizer stk;
		int n, k;
		while(T-- > 0){
			cola = new PriorityQueue<>();
			stk = new StringTokenizer(in.readLine());
			n = Integer.parseInt(stk.nextToken());
			k = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(in.readLine());
				cola.add(new Medicine(stk.nextToken(), i, Long.parseLong(stk.nextToken())));
			}
			Medicine actual;
			while(k-- >0){
				actual = cola.poll();
				out.write(actual.frecuenciaActual+" "+actual.name+"\n");
				actual.siguiente();
				cola.add(actual);
			}
			
			
		}
		out.close();
		in.close();
	}
	
	

}

class Medicine implements Comparable<Medicine>{
	String name;
	int priority;
	long frecuenciaIncial;
	long frecuenciaActual;
	
	Medicine(String name, int priority, long frecuency){
		this.name = name;
		this.priority = priority;
		this.frecuenciaIncial = frecuency;
		this.frecuenciaActual = frecuenciaIncial;
	}
	
	void siguiente(){
		frecuenciaActual+= frecuenciaIncial;
	}
	
	
	@Override
	public int compareTo(Medicine m) {
		
		if(m.frecuenciaActual == frecuenciaActual) return Integer.compare(priority, m.priority);
		return Long.compare(frecuenciaActual, m.frecuenciaActual);
	}
}
