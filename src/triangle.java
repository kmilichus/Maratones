
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maraton
 */
public class triangle {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static long triangulos[] = new long[501];

    public static void main(String args[]) throws Exception {

        int num;
        long  anterior,arriba,abajo;
        String line;
        
        triangulos[0] = 0;    
        anterior = 0;
        arriba=0;
        abajo=0;
        
        for (int i = 1; i < triangulos.length; i++) {
        	abajo = anterior-abajo;
           	anterior = i+anterior;
        	arriba = anterior +triangulos[i-1];
        	triangulos[i]= arriba+abajo;
        }
        

        while(true) {
            line = in.readLine();
            if(line == null || line.isEmpty())
                break;
            num = Integer.valueOf(line);
            
                                              
            out.write(triangulos[num]+"\n");
        }

        out.flush();
        out.close();
        in.close();
    }
}
