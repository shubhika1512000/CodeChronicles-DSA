import java.util.Scanner;

public class onechicken {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int peep = sc.nextInt();
        int chick = sc.nextInt();
        
        int diff = peep - chick;
        
        if( diff > 0) {
            System.out.println(
                "Dr. Chaz needs " +
                diff
                +" more piece" +
                (diff==1?"":"s")
                + " of chicken!"
            );
        } 
        else if ( diff < 0) {
            System.out.println(
                "Dr. Chaz will have " +
                Math.abs(diff)
                + " piece" +
                (diff==-1?"":"s")
                + " of chicken left over!"
            );
        }
        else {
            // not the case
        }
        
        sc.close();
    }
}