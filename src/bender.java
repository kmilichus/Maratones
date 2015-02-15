
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
public class bender {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    // 0  1  2  3  4  5
    // x+ x- y+ y- z+ z-
    static int positions[][] = {
        {0, 1, 2, 3, 4, 5},
        {1, 0, 3, 2, 5, 4},
        {2, 3, 1, 0, 2, 2},
        {3, 2, 0, 1, 3, 3},
        {4, 4, 4, 4, 1, 0},
        {5, 5, 5, 5, 0, 1}};

    public static void main(String args[]) throws Exception {

        int L, ultimo;
        StringTokenizer tokens;
        String lectura;

        while (true) {

            L = Integer.valueOf(in.readLine());
            if (L == 0) {
                break;
            }

            tokens = new StringTokenizer(in.readLine());

            ultimo = 0;
            while (tokens.hasMoreTokens()) {
                
                lectura = tokens.nextToken();
                
                switch (lectura.charAt(1)) {

                    case 'x':
                        if(lectura.charAt(0) == '+')
                            ultimo = positions[ultimo][0];
                        else
                            ultimo = positions[ultimo][1];
                        break;

                    case 'y':
                        if(lectura.charAt(0) == '+')
                            ultimo = positions[ultimo][2];
                        else
                            ultimo = positions[ultimo][3];
                        break;

                    case 'z':
                        if(lectura.charAt(0) == '+')
                            ultimo = positions[ultimo][4];
                        else
                            ultimo = positions[ultimo][5];
                        break;

                }
            }

            switch (ultimo) {

                case 0:
                    out.write("+x\n");
                    break;

                case 1:
                    out.write("-x\n");
                    break;

                case 2:
                    out.write("+y\n");
                    break;

                case 3:
                    out.write("-y\n");
                    break;

                case 4:
                    out.write("+z\n");
                    break;

                case 5:
                    out.write("-z\n");
                    break;
            }

        }

        out.flush();
        out.close();
        in.close();
    }
}
