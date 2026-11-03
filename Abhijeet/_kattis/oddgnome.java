import java.util.Scanner;

public class oddgnome {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();
        
        for(int t=0; t < test; t++){
            int num = sc.nextInt();
            
            int prenum = sc.nextInt();
            boolean isFound = false;
            for(int i=2; i <= num; i++) {
                int inum = sc.nextInt();
                
                if(inum != prenum+1) {
                    if(!isFound){
                        System.out.println(i);
                        isFound = true;
                    }
                }
                
                prenum = inum;
            }
        }
        
        sc.close();
    }
}