// LeetCode 365 - Water Jug Problem
// Approach: Optimal using Math (GCD - Bezout's Identity)
// Time Complexity: O(log(min(x, y))) | Space Complexity: O(1)

// IDEA:
// This is a pure math problem.
// You can measure exactly 'target' liters if and only if:
//   1. target <= x + y  (can't exceed total capacity)
//   2. target is divisible by GCD(x, y)
//
// Why GCD? Every amount measurable using jug x and jug y
// is always a multiple of GCD(x, y).
// This is known as Bezout's Identity: ax + by = target
// has a solution if and only if GCD(x, y) divides target.

public class WaterJugOptimal {

    // Helper: find GCD using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public boolean canMeasureWater(int x, int y, int target) {
        // Can't measure more than total capacity
        if (target > x + y) return false;

        // target must be a multiple of GCD(x, y)
        return target % gcd(x, y) == 0;
    }

    public static void main(String[] args) {
        WaterJugOptimal solution = new WaterJugOptimal();

        // Test case 1
        System.out.println("Input:  x=3, y=5, target=4");
        System.out.println("Output: " + solution.canMeasureWater(3, 5, 4));
        // GCD(3,5)=1, 4%1=0 → true

        System.out.println();

        // Test case 2
        System.out.println("Input:  x=2, y=6, target=5");
        System.out.println("Output: " + solution.canMeasureWater(2, 6, 5));
        // GCD(2,6)=2, 5%2=1 → false

        System.out.println();

        // Test case 3
        System.out.println("Input:  x=1, y=2, target=3");
        System.out.println("Output: " + solution.canMeasureWater(1, 2, 3));
        // GCD(1,2)=1, 3%1=0 → true
    }
}
