import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Andres Villegas on 2017-04-08.
 */
public class BathroomStalls {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = Integer.parseInt(in.readLine());
        StringTokenizer stk;
        for (int t = 1; t <= T; t++) {
            stk = new StringTokenizer(in.readLine());
            long N = Long.parseLong(stk.nextToken());
            long K = Long.parseLong(stk.nextToken());
            Pair sol = solve(N,K);
            out.printf("Case #%d: %d %d\n", t, sol.first, sol.second);

        }

        out.close();
        in.close();

    }


    static Pair solve(long N, long K){
        int i = 1;
        PriorityQueue<Long> maxs = new PriorityQueue<>();
        maxs.add(-N);
        long actual;
        long temp=0;
        long min, max;
        while(i <= K){
            actual = maxs.poll();
            temp = (-actual)-1;
            min = temp/2;
            max = temp-min;
            if(i==K) return new Pair(max, min);
            maxs.add(-max);
            maxs.add(-min);
            i++;
        }
        return new Pair(-1, -1);
    }
}

class Pair{
    long first;
    long second;

    public Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

