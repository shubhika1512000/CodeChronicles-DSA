import java.util.Scanner;

public class provincesandgold {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int gold = sc.nextInt();
        int silver = sc.nextInt();
        int copper = sc.nextInt();
        
        int totalBuyingPower = gold*3 + silver*2 + copper*1;
        
        if(totalBuyingPower >= 8) {
            System.out.println("Province or Gold");
        }
        else if(totalBuyingPower >= 6) {
            System.out.println("Duchy or Gold");
        }
        else if(totalBuyingPower >= 5) {
            System.out.println("Duchy or Silver");
        }
        else if(totalBuyingPower >= 3) {
            System.out.println("Estate or Silver");
        }
        else if(totalBuyingPower >= 2) {
            System.out.println("Estate or Copper");
        }
        else {
            System.out.println("Copper");
        }

        sc.close();
    }
}