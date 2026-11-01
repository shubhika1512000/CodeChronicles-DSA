import java.util.Scanner;
public class licensetolaunch {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int days = sc.nextInt();
        
        int day = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<days; i++) {
            int d = sc.nextInt();
            
            if(d < min) {
                day = i;
                min = d;
            } 
        }
        
        System.out.println(day);
        
        sc.close();
    }
}