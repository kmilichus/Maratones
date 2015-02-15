
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maraton
 */
public class tennis {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {

        String line;
        char partido[];
        int marcadorA, marcadorB, puntosA, puntosB;
        boolean sirviendo;
        boolean deuce;
        
        while(true) {
            
            line = in.readLine();
            if(line == null || line.isEmpty())
                break;
            
            marcadorA = 0;
            marcadorB = 0;
            puntosA = 0;
            puntosB = 0;
            sirviendo = true;
            deuce = false;
            partido = line.toCharArray();
            for (int i = 0; i < partido.length; i++) {
                if(sirviendo) {
                    if(partido[i] == 'S') {
                        puntosA ++;
                    } else {
                        puntosB ++;
                    }
                } else {
                    if(partido[i] == 'S') {
                        puntosB ++;
                    } else {
                        puntosA ++;
                    }
                }
                
                if(puntosA == puntosB && puntosA == 3)
                    deuce = true;
                
                if(deuce) {
                    if(puntosA - puntosB > 1) {
                        marcadorA ++;
                        if(marcadorA >= 6 && marcadorA - marcadorB > 1)
                            break;
                        puntosA = 0;
                        puntosB = 0;
                        deuce = false;
                        sirviendo = !sirviendo;
                    } else if(puntosB - puntosA > 1) {
                        marcadorB ++;
                        if(marcadorB >= 6 && marcadorB - marcadorA > 1)
                            break;
                        puntosA = 0;
                        puntosB = 0;
                        deuce = false;
                        sirviendo = !sirviendo;
                    }
                } else {
                    if(puntosA == 4) {
                        marcadorA ++;
                        if(marcadorA >= 6 && marcadorA - marcadorB > 1)
                            break;
                        puntosA = 0;
                        puntosB = 0;
                        sirviendo = !sirviendo;
                    } else if(puntosB == 4) {
                        marcadorB ++;
                        if(marcadorB >= 6 && marcadorB - marcadorA > 1)
                            break;
                        puntosA = 0;
                        puntosB = 0;
                        sirviendo = !sirviendo;
                    }
                }
            }
            
            out.write(marcadorA+"-"+marcadorB+"\n");
        }
        
        out.flush();
        out.close();
        in.close();
        
    }
}
