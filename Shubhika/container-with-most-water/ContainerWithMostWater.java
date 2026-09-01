// LeetCode 11 - Container With Most Water
// Approach: Two Pointers
// Time Complexity: O(n) | Space Complexity: O(1)

// IDEA:
// Place one pointer at the left end and one at the right end.
// Water stored = distance between pointers × height of the shorter line
// The shorter line is the bottleneck — moving it inward gives a chance
// of finding a taller line and storing more water.
// Moving the taller line inward can never help (distance shrinks + height won't improve).

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Width between the two pointers
            int width = right - left;

            // Height is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);

            // Water this container can hold
            int currentWater = width * currentHeight;

            // Update max if better
            maxWater = Math.max(maxWater, currentWater);

            // Move the shorter line inward (it's the bottleneck)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input:  [1, 8, 6, 2, 5, 4, 8, 3, 7]");
        System.out.println("Output: " + solution.maxArea(height1));
        // Output: 49  (lines at index 1 and 8: min(8,7) * 7 = 49)

        System.out.println();

        // Test case 2
        int[] height2 = {1, 1};
        System.out.println("Input:  [1, 1]");
        System.out.println("Output: " + solution.maxArea(height2));
        // Output: 1
    }
}
