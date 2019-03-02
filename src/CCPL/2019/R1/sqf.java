import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class sqf {

	static Category[] categories;
	static LinkedList<String> problem;
	static final int A = (int)'A';
	static final int a = (int)'a';
	static final int Z = (int)'Z';
	static final int z = (int)'z';

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());

		while(N-->0) {

			int cat = Integer.parseInt(in.readLine());

			categories = new Category[cat];
			StringTokenizer stk = null;

			for (int i = 0; i < cat; i++) {

				stk = new StringTokenizer(in.readLine());

				String name = removeInvalid(stk.nextToken().trim());
				int size = Integer.parseInt(stk.nextToken());
				int goal = Integer.parseInt(stk.nextToken());

				Category current = new Category(name, size, goal);

				for (int j = 0; j < size; j++) {
					current.keywords.add(removeInvalid(in.readLine().trim()));
				}
				categories[i] = current;

			}

			// queries
			problem = new LinkedList<>();

			String line = in.readLine();

			while(line !=null && !line.equals("")) {
				stk = new StringTokenizer(line);

				while(stk.hasMoreTokens()) {
					addWords(stk.nextToken().trim());
				}
				line = in.readLine();
			}


			int[] apperences = new int[categories.length];

			StringBuilder sb = new StringBuilder();

//			System.out.println(Arrays.toString(categories));
			
			for (int i = 0; i < problem.size(); i++) {
				String s = problem.get(i);
//				System.out.println("Buscando -> "+s);
				
				for ( int j = 0; j < categories.length; j++ ) {
					if ( categories[j].keywords.contains(s) ) {
						apperences[j]++;
//						System.out.println("Encontre " +s+" en "+ categories[j].name);
						categories[j].keywords.remove(s);
//						System.out.println(categories[j].keywords);
					}
				}

			}	

			int total =0;
			
	
//			System.out.println(Arrays.toString(apperences));

			for (int i = 0; i < categories.length; i++) {

				if(apperences[i] >= categories[i].goal) {
					if ( total > 0 ) 
						sb.append(",");
					sb.append(categories[i].name);
					total++;
				}
			}

			if(total==0)
				out.write("SQF Problem.\n");
			else
				out.write(sb.toString()+"\n");

		}

		in.close();
		out.close();

	}


	private static void addWords(String token) {
		
		StringBuilder sb = new StringBuilder();

		char[] arr = token.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			int x = (int)arr[i];
			if(x>=A && x<=Z || x>=a && x<=z) {
				sb.append(""+arr[i]);
			}else {
				problem.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		
		problem.add(sb.toString());

		
	}


	private static String removeInvalid(String token) {

		StringBuilder sb = new StringBuilder();

		char[] arr = token.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			int x = (int)arr[i];
			if(x>=A && x<=Z || x>=a && x<=z) {
				sb.append(""+arr[i]);
			}
		}

		return sb.toString();
	}


	public static class Category{

		String name;
		int keywordsSize;
		int goal;
		TreeSet<String> keywords;

		public Category(String name, int keywordSize, int goal) {
			this.name = name;
			this.keywordsSize = keywordSize;
			this.goal = goal;
			this.keywords = new TreeSet<>();
		}


		@Override
		public String toString() {
			return name +" - "+ goal + " " +keywords.toString();
		}




	}



}

