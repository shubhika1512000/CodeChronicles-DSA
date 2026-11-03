import java.util.Scanner;

public class eligibilty {
    
    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           
           int numTest = sc.nextInt();
           
           for(int i=0; i < numTest; i++) {
               String name = sc.next();
               String beganStudyDate = sc.next();
               String birthDate = sc.next();
               int numCourses = sc.nextInt();

               int beganStudyYear = Integer.parseInt(beganStudyDate.trim().substring(0, 4));
               int birthYear = Integer.parseInt(birthDate.trim().substring(0, 4));

               if(birthYear >= 1991 || beganStudyYear >= 2010) {
                    // elibgible
                    System.out.println(name + " eligible");
               }
               else if(numCourses >= 41){
                    // ineligible
                    System.out.println(name + " ineligible");
               }
               else {
                    // coach petition
                    System.out.println(name + " coach petitions");
               }
           }
           
           sc.close();
    }
}