package moscowdream;

import java.util.Scanner;


public class moscowdream_CORRECT {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        
        boolean isPossible = 
            a >= 1 &&
            b >= 1 &&
            c >= 1 &&
            n >= 3 && (a+b+c >= n);
            
        System.out.print(isPossible? "YES": "NO");
        
        sc.close();
    }
}

/**
 * Intrinsic Test case: 
 *  n >= 3, must be checked because we must have atleast 1 easy, medium and hard problem in our set.
 *  So, it must need to have atleast 3 questions in the set.
 * 
*/