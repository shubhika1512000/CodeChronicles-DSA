import java.util.Scanner;

public class different {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLong()) {
            long i = sc.nextLong();
            long j = 0;
            if(sc.hasNextLong())
                j = sc.nextLong();
        
            System.out.println(Math.abs(i-j));
        }
        
        sc.close();
    }
}
