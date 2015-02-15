
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maraton
 */
public class pursuit {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static long externos[] = new long[500];

    public static void main(String args[]) throws Exception {

        int tx, ty, tsx, tsy, cx, cy, csx, csy;
        String line;
        StringTokenizer tokens;

        while(true) {
            
            line = in.readLine();
            if(line == null || line.isEmpty())
                break;
            
            tokens = new StringTokenizer(line);
            tx = Integer.valueOf(tokens.nextToken());
            ty = 0;
            tsx = Integer.valueOf(tokens.nextToken());
            tsy = Integer.valueOf(tokens.nextToken());
            cx = 0;
            cy = 0;
            csx = 0;
            csy = 0;
            
            
        }
        
        out.flush();
        out.close();
        in.close();
    }
}
