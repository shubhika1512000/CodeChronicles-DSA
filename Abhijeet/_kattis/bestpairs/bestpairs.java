package bestpairs;
import java.util.HashSet;
import java.util.Set;

public class bestpairs {
    
    public static void main(String[] args) {
        int[][] points_ = new int[4][2];
        points_[0][0] = 1;  points_[0][1] = 1;
        points_[1][0] = 8;  points_[1][1] = 6;
        points_[2][0] = 6;  points_[2][1] = 8;
        points_[3][0] = 1;  points_[3][1] = 3;  
        
        System.out.println("Cost: " + points(points_));
    }

    public static double points(int[][] points) {
        int n = points.length;
        double[][] costMatrix = new double[n][n];

        // Only fill upper triangle (i < j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                costMatrix[i][j] = cost(points[i], points[j]);
            }
        }

         double minTotal = Double.MAX_VALUE;

        // Try all possible starting pairs (0,i)
        for (int i = 1; i < n; i++) {
            Set<Integer> vset = new HashSet<>();
            vset.add(0);
            vset.add(i);
            double total = costMatrix[0][i];

            minTotal = Math.min(dfs(vset, costMatrix, total, Double.MAX_VALUE), minTotal);
        }

        return minTotal;
    }

    public static double dfs(Set<Integer> vset, double[][] costMatrix, double total, double minTotal) {
        int length = costMatrix.length;

        // Base case: all points paired
        if (vset.size() == length) {
            return Math.min(total, minTotal);
        }

        // Find next unpaired point
        int first = -1;
        for (int i = 0; i < length; i++) {
            if (!vset.contains(i)) {
                first = i;
                break;
            }
        }

        vset.add(first);
        for (int j = first + 1; j < length; j++) {
            if (!vset.contains(j)) {
                vset.add(j);
                double newTotal = total + costMatrix[Math.min(first, j)][Math.max(first, j)];
                minTotal = dfs(vset, costMatrix, newTotal, minTotal);
                vset.remove(j); // backtrack
            }
        }
        vset.remove(first); // backtrack

        return minTotal;
    }

    public static double cost(int[] i, int[] j){
        double c0 = (i[0]-j[0]);
        double c1 = (i[1]-j[1]);
        
        return Math.sqrt(Math.pow(c0,2) + Math.pow(c1,2));
    }

}
