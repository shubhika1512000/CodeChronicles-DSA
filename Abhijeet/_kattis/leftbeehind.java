import java.util.Scanner;

public class leftbeehind {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()) {
            int sweet = sc.nextInt();
            int sour = sc.nextInt();
            
            if( (sour + sweet) == 0) {
                break;
            }
            else if((sour + sweet) == 13) {
                System.out.println("Never speak again.");
            }
            else {
                if(sweet > sour) {
                    System.out.println("To the convention.");
                }
                else if(sweet < sour) {
                    System.out.println("Left beehind.");
                }
                else {
                    System.out.println("Undecided.");
                }
            }
        }
            
        sc.close();
    }
}