import java.util.Scanner;

public class helpaphd {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numTest = sc.nextInt();
        
        for(int t=0; t < numTest; t++) {
            String expr = sc.next().trim();
            int i = expr.indexOf('+');

            if(i > 0) {
                int a = Integer.parseInt(expr.substring(0, i));
                int b = Integer.parseInt(expr.substring(i+1));
                
                System.out.println(a+b);
            }
            else{
                // P=NP
                System.out.println("skipped");
            }

        }
        
        sc.close();
    }
}