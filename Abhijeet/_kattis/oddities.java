import java.util.Scanner;

public class oddities {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cases = sc.nextInt();
        
        for(int tcase = 1; tcase <= cases; tcase++) {
            int x = sc.nextInt();
            
            if(x%2 == 0) {
                System.out.print(x + " is even");            
            }
            else {
                System.out.print(x + " is odd"); 
            }
            
            // new line condition
            if(tcase < cases) System.out.println();
        }
        
        sc.close();
    }
}