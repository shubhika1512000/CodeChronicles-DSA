import java.util.Scanner;

public class isithalloween {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String month = sc.next();
        int date = sc.nextInt();
        
        boolean isHalloween = 
            (month.equals("OCT") && date == 31) ||
            (month.equals("DEC") && date == 25);      
        
        System.out.println(isHalloween? "yup": "nope");
        
        sc.close();
    }
}