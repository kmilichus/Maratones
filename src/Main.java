import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) { 
    	// Double de prueba
    	double hola = 12.1239157480;
    	// Creo el Decimal format
    	DecimalFormat df = new DecimalFormat("0.0");
    	// La cantidad de 0 despues del punto son la cantidad de Decimales
    	//Imprimo en consola
    	System.out.println(df.format(hola));
    }
}