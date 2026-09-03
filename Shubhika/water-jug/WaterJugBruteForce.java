// LeetCode 365 - Water Jug Problem
// Approach: Brute Force using BFS (simulate all possible states)
// Time Complexity: O(x * y) | Space Complexity: O(x * y)

// IDEA:
// Think of it as a graph problem.
// Each state is (amountInJug1, amountInJug2).
// From any state, we can perform 6 operations:
//   1. Fill jug1
//   2. Fill jug2
//   3. Empty jug1
//   4. Empty jug2
//   5. Pour jug1 into jug2
//   6. Pour jug2 into jug1
// Use BFS to explore all reachable states.
// If we ever reach a state where jug1 or jug2 or jug1+jug2 == target, return true.

import java.util.*;

public class WaterJugBruteForce {

    public boolean canMeasureWater(int x, int y, int target) {
        // Edge case: target is more than total capacity
        if (target > x + y) return false;

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0}); // start with both jugs empty
        visited.add("0,0");

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int jug1 = state[0];
            int jug2 = state[1];

            // Check if target is reached
            if (jug1 == target || jug2 == target || jug1 + jug2 == target) {
                return true;
            }

            // All 6 possible operations
            int[][] nextStates = {
                {x, jug2},           // Fill jug1
                {jug1, y},           // Fill jug2
                {0, jug2},           // Empty jug1
                {jug1, 0},           // Empty jug2
                {Math.max(0, jug1 - (y - jug2)), Math.min(y, jug1 + jug2)},  // Pour jug1 → jug2
                {Math.min(x, jug1 + jug2), Math.max(0, jug2 - (x - jug1))}  // Pour jug2 → jug1
            };

            for (int[] next : nextStates) {
                String key = next[0] + "," + next[1];
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(next);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WaterJugBruteForce solution = new WaterJugBruteForce();

        // Test case 1
        System.out.println("Input:  x=3, y=5, target=4");
        System.out.println("Output: " + solution.canMeasureWater(3, 5, 4));
        // Output: true

        System.out.println();

        // Test case 2
        System.out.println("Input:  x=2, y=6, target=5");
        System.out.println("Output: " + solution.canMeasureWater(2, 6, 5));
        // Output: false

        System.out.println();

        // Test case 3
        System.out.println("Input:  x=1, y=2, target=3");
        System.out.println("Output: " + solution.canMeasureWater(1, 2, 3));
        // Output: true
    }
}
