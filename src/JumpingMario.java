import java.util.*;
 
public class JumpingMario{
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casos = input.nextInt();
        for (int i = 1; i<= casos; i++){
            int n = input.nextInt();
            int [] saltos = new int[n];
            int alto = 0;
            int bajo = 0;
            for (int j = 0; j < n; j++)
                saltos[j] = input.nextInt();
                  for (int j = 0; j < n-1; j++){
                      if (saltos[j+1] > saltos[j])
                          alto ++;
                      else if (saltos[j+1] < saltos[j])
                          bajo ++;
                      else if (saltos[j+1] == saltos[j]){
                           
                      }
                  }
            System.out.println("Case " + i +": " + alto +" "+ bajo);
        }
    }
}