// LeetCode 53 - Maximum Subarray
// Approach: Kadane's Algorithm
// Time Complexity: O(n) | Space Complexity: O(1)

// IDEA:
// At every index, we have two choices:
//   1. Extend the current subarray by adding nums[i]
//   2. Start a new subarray from nums[i] (if current sum went negative, drop it)
// Keep track of the maximum sum seen so far.

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];  // sum of current subarray
        int maxSum = nums[0];      // best sum found so far

        for (int i = 1; i < nums.length; i++) {
            // If currentSum is negative, starting fresh is better
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            // Update max if we found a better sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Output: " + solution.maxSubArray(nums1));
        // Output: 6  (subarray: [4, -1, 2, 1])

        System.out.println();

        // Test case 2
        int[] nums2 = {1};
        System.out.println("Input:  [1]");
        System.out.println("Output: " + solution.maxSubArray(nums2));
        // Output: 1

        System.out.println();

        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Input:  [5, 4, -1, 7, 8]");
        System.out.println("Output: " + solution.maxSubArray(nums3));
        // Output: 23  (subarray: [5, 4, -1, 7, 8])
    }
}
