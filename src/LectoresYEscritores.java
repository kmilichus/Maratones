import java.io.*;
import java.util.Scanner;

public class LectoresYEscritores {

	public static void main(String[] args) throws IOException {

			
	// Buffered Reader es la lectura buffereada "Va guardando en una cajita".
	// Para leer la proxima linea utiliza el método .readLine()
	// Para maratones dejen que la exception se propague
		
			
	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
	lector.readLine();

	// Buffered Writer espara la escritura bufferead a"Va guardando en una cajita y al final imprime".
	// Para que imprima las cosas al final de la clase necesitan utilizar el metodo .flush()
	
	BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out));
	escritor.flush();
	
	
	// Otra forma de leer es el scanner
	// Para leer la proxima linea utilizan el método .nextLine();
	
	Scanner lector2 = new Scanner(System.in);
	lector2.nextLine();
	
	//Otra forma de imprimir el es System.out
	//Este system.out puede imprimir de 2 formas
	//La primera forma es con un salto de linea
	
	System.out.println("lo que quiero imprimir");
	
	// La otra forma es sin el salto de linea
	
	System.out.print("Lo que quiero imprimir sin salto de linea");
	
	
	
	
	
	
	
	}
}
