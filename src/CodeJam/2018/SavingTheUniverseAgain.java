import java.io.*;
import java.util.StringTokenizer;

public class SavingTheUniverseAgain {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));



		int T  = Integer.parseInt(in.readLine());
		int cases = 1;

		while (T-->0) {

			StringTokenizer stk = new StringTokenizer(in.readLine());
			int shield = Integer.parseInt(stk.nextToken());
			char[] robot = stk.nextToken().toCharArray();
			
			int taken = findDamage(robot);
			int hacks = 0;
			boolean imposible = false;
			
			if (shield<taken) {				
				while (shield<taken && !imposible) {
					if (!bestHack(robot, taken)) {
						imposible = true;
					}else {
						++hacks;
						taken = findDamage(robot);
					}		
				}
			}
			
			if(imposible)
				out.write("Case #"+cases+": IMPOSSIBLE\n");
			else
				out.write("Case #"+cases+": "+hacks+"\n");

			++cases;
		}

		in.close();
		out.close();
	}

	private static int findDamage(char[] robot) {
		int damage = 1;
		int taken = 0;
		
		for (int i = 0; i < robot.length; i++) {		
			if (robot[i]=='C') {
				damage*=2;
			}else {
				taken += damage;
			}
		}
		return taken;
	}

	private static boolean bestHack(char[] robot, int taken) {

		boolean found = false;
		
		for (int i = robot.length-1; i >0 && !found ; i--) {
			
			if(robot[i]=='S' && robot[i-1]=='C'){
				robot[i]= 'C';
				robot[i-1]= 'S';
				found = true;		
			}	
		}
		
		return found;
	}



}
