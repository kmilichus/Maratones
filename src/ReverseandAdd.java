import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class ReverseandAdd{
 
    public static void main(String[] args) throws Exception{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(lector.readLine());
        for (int t = 0; t < n; t++) {
            String x = lector.readLine();
            String y = new StringBuffer(x).reverse().toString();
            long suma = Long.parseLong(x) + Long.parseLong(y);
            int cont = 1;
            while (!isPalindrome(Long.toString(suma))) {
                cont++;
                x = Long.toString(suma);
                y = new StringBuffer(x).reverse().toString();
                suma = Long.parseLong(x) + Long.parseLong(y);
            }
            System.out.println(cont + " " + suma);
        }
    }
 
    private static boolean isPalindrome(String suma) {
        for (int i = 0; i < suma.length() / 2; i++) {
            if (suma.charAt(i) != suma.charAt(suma.length() - 1 - i))
                return false;
        }
        return true;
    }
}