import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TexQuotes {

    public static void main(String[] args) throws IOException {
    	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String respuesta= "";
        String line = "";
        boolean flag=true;
        
        while ((line = lector.readLine()) != null) {
            
            for(int i=0;i<line.length();i++){
                if(line.charAt(i)=='"'){
                    if(flag){
                    	respuesta+= "``";
                        flag=false;
                    }else{
                    	respuesta+= "''";
                        flag=true;
                    }
                }else{
                	respuesta+= line.charAt(i);
                    
                }
            }
            respuesta+= "\n";
                        
        }
        System.out.print(respuesta);
    }
}