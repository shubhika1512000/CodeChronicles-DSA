package moscowdream;
import java.util.Scanner;

public class moscowdream_WRONG {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        
        boolean isPossible = 
            a >= 1 && 
            b >= 1 && 
            c >= 1 && (a+b+c >= n);
            
        System.out.println(isPossible? "YES": "NO");
        
        sc.close();
    }
}

/**
 * HINT: 
 * What is wrong with this condition ? 
 * 
 */