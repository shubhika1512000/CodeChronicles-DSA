// LeetCode 268 - Missing Number
// Approach: Math (Expected Sum - Actual Sum)
// Time Complexity: O(n) | Space Complexity: O(1)

// IDEA:
// Array contains n distinct numbers from range [0, n].
// One number is missing.
// Sum of 0 to n = n * (n + 1) / 2  (formula)
// Missing number = expected sum - actual sum of array

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Expected sum if no number was missing
        int expectedSum = n * (n + 1) / 2;

        // Actual sum of the array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // The difference is the missing number
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();

        // Test case 1
        int[] nums1 = {3, 0, 1};
        System.out.println("Input:  [3, 0, 1]");
        System.out.println("Output: " + solution.missingNumber(nums1));
        // Expected sum = 6, Actual sum = 4 → missing = 2

        System.out.println();

        // Test case 2
        int[] nums2 = {0, 1};
        System.out.println("Input:  [0, 1]");
        System.out.println("Output: " + solution.missingNumber(nums2));
        // Expected sum = 3, Actual sum = 1 → missing = 2

        System.out.println();

        // Test case 3
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Input:  [9, 6, 4, 2, 3, 5, 7, 0, 1]");
        System.out.println("Output: " + solution.missingNumber(nums3));
        // Expected sum = 45, Actual sum = 37 → missing = 8
    }
}
