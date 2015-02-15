import java.util.Scanner;
 
public class SummingDigits{
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            long num = input.nextLong();
            if (num == 0)
                break;
            String s = Long.toString(num);
            int x = count(s);
            System.out.println(x);
        }
    }
 
    static int count(String s) {
        if (s.length() == 1)
            return Integer.parseInt(s);
        else {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sum += Integer.parseInt(Character.toString(c));
            }
            return count(Integer.toString(sum));
        }
    }
}