import java.util.Scanner;

public class tarifa {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int perMonthPlan = sc.nextInt();
        int numMonths = sc.nextInt();
        
        int totalRem = 0;
        
        while(numMonths > 0) {
            totalRem = (totalRem + perMonthPlan) - sc.nextInt();
            numMonths--;
        }
        
        System.out.println(totalRem + perMonthPlan);

        sc.close();
    }
}