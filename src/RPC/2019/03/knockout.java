import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class knockout {

	private static int possibleRolls[][][] = {
			/*  0 */ {{}},
			/*  1 */ {{}},
			/*  2 */ {{2}},
			/*  3 */ {{3},{1,2}},
			/*  4 */ {{4},{1,3}},
			/*  5 */ {{5},{1,4},{2,3}},
			/*  6 */ {{6},{1,5},{2,4},{1,2,3}},
			/*  7 */ {{7},{1,6},{2,5},{3,4},{1,2,4}},
			/*  8 */ {{8},{1,7},{2,6},{3,5},{1,2,5},{1,3,4}},
			/*  9 */ {{9},{1,8},{2,7},{3,6},{4,5},{1,2,6},{1,3,5},{2,3,4}},
			/* 10 */ {{1,9},{2,8},{3,7},{4,6},{1,2,7},{1,3,6},{1,4,5},{2,3,5},{1,2,3,4}},
			/* 11 */ {{2,9},{3,8},{4,7},{5,6},{1,2,8},{1,3,7},{1,4,6},{2,3,6},{2,4,5},{1,2,3,5}},
			/* 12 */ {{3,9},{4,8},{5,7},{1,2,9},{1,3,8},{1,4,7},{1,5,6},{2,3,7},{2,4,6},{3,4,5},{1,2,3,6},{1,2,4,5}}};

	private static double prob[] = {0.0, 0.0, 1.0/36.0, 2.0/36.0, 3.0/36.0, 4.0/36.0, 5.0/36.0, 6.0/36.0, 5.0/36.0, 4.0/36.0, 3.0/36.0, 2.0/36.0, 1.0/36.0};

	private static boolean[] digits;

	/** Maximize (true) or Minimize (false)? */
	private static boolean max;

	private static String ans;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		StringTokenizer stk = new StringTokenizer(in.readLine());

		digits = new boolean[10];

		addDigits(stk.nextToken());

		int diceRoll = Integer.parseInt(stk.nextToken()) + Integer.parseInt(stk.nextToken());

		max = false;       
		ans = "-1";        
		double worst = takeTurn( diceRoll, true );
		out.printf( "%s %.5f", ans, worst);
		out.println();


		max = true;       
		ans = "-1";        
		double best = takeTurn( diceRoll, true );
		out.printf("%s %.5f", ans, best);
		out.println();


		out.close();
		in.close();

	}

	private static void addDigits(String nextToken) {

		for (int i = 0; i < nextToken.length(); i++) {
			digits[nextToken.charAt(i)-'0'] = true;			
		}

	}


	private static double takeTurn( int diceRoll, boolean top ){
		double best = max ? -1.0 : 10000000000.0;

		// Go through all digit combinations possible for this roll
		for( int takes[] : possibleRolls[diceRoll]){
			// Are all of the digits available?
			boolean moreMoves = true;
			for( int take : takes ) if( !digits[take] ) moreMoves = false;
			if( moreMoves ){

				double result = 0.0;
				for( int take : takes ) digits[take] = false; 
				for( int r=2; r<=12; r++ ) result += prob[r]*takeTurn(r,false);
				for( int take : takes ) digits[take] = true; 

				// Is this better than anything we've seen so far?
				if( max ? result>best : result<best ) {
					best = result;                        
					// We're only interested in saving the digits taken at the top level 
					if( top ) {
						ans = "";
						for( int take : takes ) ans += (char)(take+'0');  
//						System.out.println(ans);
					}
				}
			}
		}

		// If best is out of range, that means we couldn't play any combo of digits.
		// So, the result is just the digits we've got.
		return best<0.0 || best>9999999999.0 ? getPoints( digits ) : best ;
	}

	private static int getPoints( boolean digits[] ){
		int total = 0;
		for( int i=0; i<digits.length; i++ ) {
			if( digits[i] ){
				total *= 10;
				total += i;
			}
		}
		return total;
	}

}
