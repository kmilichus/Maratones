import java.io.*;
import java.util.Map.Entry;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;

public class sultan {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(in.readLine());

		int cases = 1;
		while(t-->0) {

			char[] arr = in.readLine().toCharArray();
			Stack<Character> pila =new Stack<Character>(); 
			TreeMap<Character, LinkedList<Character> > g = new TreeMap<>();

			for (int i = 0; i < arr.length; i++) {
				if(i-1<0) {
					pila.push(arr[i]);
				}else{					
					if(pila.peek() == arr[i]) {
						pila.pop();
					}else{
						char tmp = pila.peek();
						if(!g.containsKey(tmp))
							g.put(tmp, new LinkedList<>());
						if(!g.get(tmp).contains(arr[i]))
							g.get(tmp).add(arr[i]);
						if(!g.containsKey(arr[i]))
							g.put(arr[i], new LinkedList<>());
						if(!g.get(arr[i]).contains(tmp))
							g.get(arr[i]).add(tmp);
						pila.push(arr[i]);
					}
				}

			}
			
			
			out.write("Case "+cases+"\n");

			for(Entry<Character, LinkedList<Character>> entry : g.entrySet()) {
				char key = entry.getKey();
				LinkedList<Character> value = entry.getValue();
//				System.out.println(key + " => " + value);
				out.write(key +" = "+value.size()+"\n");
				
			}


			cases++;
		}


		in.close();
		out.close();

	}

	

}

