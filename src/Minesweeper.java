import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Minesweeper{

    public static void main(String[] args) throws Exception {
    	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int cont=0;
        char[] line= new char[100];
        String[] tamaño= new String[2];
        salir:
       while(true){
    	   	tamaño = lector.readLine().split(" ");
            int x=Integer.parseInt(tamaño[0]);
            int y=Integer.parseInt(tamaño[1]);
            if(x==0 && y==0)
                break salir;
            int respuesta[][]=new int[x+2][y+2];
            char [][]mapa=new char[x+2][y+2];
             
            
            for(int i=1;i<x+1;i++){
            	line = lector.readLine().toCharArray();
                for(int j=1;j<y+1;j++){
                mapa[i][j]= line[j-1];
                }
            }
            
            for(int i=1;i<x+1;i++){
                 for(int j=1;j<y+1;j++){
                     if(mapa[i][j]=='*'){
                             respuesta[i-1][j]++;
                             respuesta[i+1][j]++; 
                             respuesta[i][j-1]++;
                             respuesta[i][j+1]++;
                             respuesta[i-1][j-1]++; 
                             respuesta[i-1][j+1]++;
                             respuesta[i+1][j-1]++;  
                             respuesta[i+1][j+1]++; 
                     }
                 }
            }
            if (++cont > 1) System.out.println();
            System.out.println("Field #" + cont + ":");
            for(int i=1;i<x+1;i++){
               for(int j=1;j<y+1;j++){
                   if(mapa[i][j]=='*'){
                       System.out.print('*');
                   } else{
                      System.out.print(respuesta[i][j]); 
                   } 
               } 
                System.out.println(); 
            }
        }    
        
   }
}