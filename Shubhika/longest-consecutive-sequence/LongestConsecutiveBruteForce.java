// LeetCode 128 - Longest Consecutive Sequence
// Approach: Brute Force (Sort first, then count)
// Time Complexity: O(n log n) | Space Complexity: O(1)

// IDEA:
// Step 1: Sort the array → consecutive numbers will be next to each other
// Step 2: Walk through the sorted array and count the streak
//   - If next number = current + 1 → extend the streak
//   - If next number = current     → skip (duplicate)
//   - If next number > current + 1 → streak broke, reset to 1
// Keep track of the longest streak seen.

import java.util.Arrays;

public class LongestConsecutiveBruteForce {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Step 1: Sort the array
        Arrays.sort(nums);

        int longest = 1;
        int streak  = 1;

        // Step 2: Walk through and count streak
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                // Next consecutive number → extend streak
                streak++;

            } else if (nums[i] == nums[i - 1]) {
                // Duplicate → skip, don't reset streak

            } else {
                // Gap found → reset streak
                streak = 1;
            }

            longest = Math.max(longest, streak);
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveBruteForce solution = new LongestConsecutiveBruteForce();

        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Input:  [100, 4, 200, 1, 3, 2]");
        System.out.println("Output: " + solution.longestConsecutive(nums1));
        // Sorted: [1, 2, 3, 4, 100, 200] → streak = 4

        System.out.println();

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Input:  [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]");
        System.out.println("Output: " + solution.longestConsecutive(nums2));
        // Sorted: [0, 0, 1, 2, 3, 4, 5, 6, 7, 8] → streak = 9
    }
}
