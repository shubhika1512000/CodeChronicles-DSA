import java.util.Scanner;

public class judgingmoose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int l = sc.nextInt();
        int r = sc.nextInt();
        
        int points = 2 * Math.max(l,r);
        
        if(points == 0) {
            System.out.println("Not a moose");
        }
        else {
            System.out.println(
                l==r ? 
                ("Even " + points):
                ("Odd " + points)
            );
        }
        
        sc.close();
    }
}