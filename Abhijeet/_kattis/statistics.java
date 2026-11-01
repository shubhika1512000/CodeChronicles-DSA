import java.util.Scanner;

public class statistics {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;

        while(sc.hasNextInt()) {
            int numOfNum = sc.nextInt();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            for(int i=0; i < numOfNum; i++) {
                int num = sc.nextInt();
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            
            System.out.println(
                "Case "+ counter +
                ": " + min +
                " " + max +
                " " + (max - min)
            );

            counter++;
        }
        sc.close();
    }
}