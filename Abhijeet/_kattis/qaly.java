import java.util.Scanner;

public class qaly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPeriods = sc.nextInt();
        float total = 0;
        
        while(numOfPeriods != 0) {
            if(! sc.hasNextFloat())
                break;

            float qual = sc.nextFloat();
            float year = sc.nextFloat();
            
            total = qual * year + total;
        }
        
        System.out.printf("%1.3f", total);
        sc.close();
    }
}