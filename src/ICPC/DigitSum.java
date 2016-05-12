import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitSum {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        while(true){
            String []str=br.readLine().split(" ");
            int m=Integer.parseInt(str[0]);
            int n=Integer.parseInt(str[1]);
            if(m==0 && n==0){
                break;
            }
            sb.append(sumofDigit(n,1,1)-sumofDigit(m-1,1,1)).append("\n");
        }
        System.out.print(sb);
    }
    
    static long sumofDigit(long n, long ditInd, long poss) {
        if (n == 0) {
            return 0;
        }
        long m = n % 10;
        return n / 10 * 45 * ditInd + m * poss + m * (m - 1) / 2 * ditInd + sumofDigit(n / 10, ditInd * 10, poss + m * ditInd);
    }
}
