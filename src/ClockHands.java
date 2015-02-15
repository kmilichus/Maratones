import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ClockHands {

    public static void main(String[] args) throws IOException {
	
    	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
       
    	while(true){
            String reloj=lector.readLine();
            String[] str=reloj.split(":");
            int horas=Integer.parseInt(str[0]);
            int minutos=Integer.parseInt(str[1]);
            if(horas==0 && minutos==0)
                break;
            double angulo1=(minutos*6);
            double angulo2=(horas*(30)+30*(minutos/60.0));
            double anguloFormado=Math.abs(angulo2-angulo1);
            anguloFormado=Math.min(360-anguloFormado,anguloFormado);
            System.out.printf("%.3f\n",anguloFormado);
        }
    }
}