import java.util.Scanner;

public class fizzbuzz {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        int y = sc.nextInt();
        int N = sc.nextInt();
        
        for(int i=1; i<=N; i++) {
            if(!(isDiv(i,x) || isDiv(i,y))) {
                System.out.println(i);
            }
            else {
                if(isDiv(i,x)) {
                    System.out.print("Fizz");
                }
                if(isDiv(i,y)) {
                    System.out.print("Buzz");
                }
                
                System.out.println();
            }
        }
        sc.close();
    }
    
    public static boolean isDiv(int num, int div) {
        return (num % div) == 0;
    }
}