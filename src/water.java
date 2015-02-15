
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
public class water {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static long externos[] = new long[500];
    
    static char FLOODED = 253;
    static char POINT = 254;
    static char WALL = 255;

    public static void main(String args[]) throws Exception {

        char a = '0';
        System.out.println("-> " + (int) a);
        int filas, columnas;
        char cueva[][];
        int water, flooded;
        double pressure;
        String line;
        StringTokenizer tokens;

        while (true) {

            line = in.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            tokens = new StringTokenizer(line);

            filas = Integer.valueOf(tokens.nextToken());
            columnas = Integer.valueOf(tokens.nextToken());
            cueva = new char[filas][columnas];

            water = 1;
            flooded = 1;

            for (int i = 0; i < filas; i++) {
                cueva[i] = in.readLine().toCharArray();
                for (int j = 0; j < columnas; j++) {
                    switch (cueva[i][j]) {
                        case '.':
                            cueva[i][j] = POINT;
                            break;
                        case 'X':
                            cueva[i][j] = WALL;
                            break;
                        default:
                            cueva[i][j] -= 48;
                            break;
                    }
                }
            }

            cueva[0][0] = FLOODED; // Inundando la primara posicion de la cueva

            inundando:
            while (true) {

                water++;
                pressure = water / flooded;
                boolean mojado = true;
                boolean esPosibleSeguir = false;
                mojando:
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (cueva[i][j] == FLOODED) {
                            // Arriba
                            if (i > 0 && cueva[i - 1][j] != FLOODED && cueva[i - 1][j] != WALL) {
                                esPosibleSeguir = true;
                                if(cueva[i - 1][j] == POINT || cueva[i - 1][j] < pressure) {
                                    cueva[i - 1][j] = FLOODED;
                                    mojado = true;
                                    break mojando;
                                }
                            }
                            // Abajo
                            if (i < filas - 1 && cueva[i + 1][j] != FLOODED && cueva[i + 1][j] != WALL) {
                                esPosibleSeguir = true;
                                if(cueva[i + 1][j] == POINT || cueva[i + 1][j] < pressure) {
                                    cueva[i + 1][j] = FLOODED;
                                    mojado = true;
                                    break mojando;
                                }
                            }
                            // Izquierda
                            if (j > 0 && cueva[i][j - 1] != FLOODED && cueva[i][j - 1] != WALL) {
                                if (cueva[i][j - 1] == POINT || cueva[i][j - 1] < pressure) {
                                    cueva[i][j - 1] = FLOODED;
                                    mojado = true;
                                    break mojando;
                                }
                            }
                            // Derecha
                            if (j < columnas - 1 && cueva[i][j + 1] != FLOODED && cueva[i][j + 1] != WALL) {
                                if (cueva[i][j + 1] == POINT || cueva[i][j + 1] < pressure) {
                                    cueva[i][j + 1] = FLOODED;
                                    mojado = true;
                                    break mojando;
                                }
                            }
                        }
                    }
                }

                if(!mojado) {
                    if(!esPosibleSeguir) {
                        out.write("-1\n");
                        break inundando;
                    }
                } else {
                    boolean deboImprimir = true;
                    revisando:
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            if(cueva[i][j] < 10) {
                                deboImprimir = false;
                                break revisando;
                            }
                        }
                    }
                    if(deboImprimir) {
                        out.write(water+"\n");
                        break inundando;
                    }
                }
                
            }

        }

        out.flush();
        out.close();
        in.close();
    }
}
