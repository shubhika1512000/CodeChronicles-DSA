package arrays;

import java.util.Arrays;

/**
 * LeetCode 1480 - Running Sum of 1D Array (Easy)
 *
 * Problem: Given an array nums, return the running sum where
 * runningSum[i] = nums[0] + nums[1] + ... + nums[i].
 *
 * Approach: Single pass — accumulate the sum in-place (or into a result array)
 * by adding the previous element to the current one at each step.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(n) for the result array (O(1) extra if done in-place)
 */
public class RunningSum {

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Running Sum: " + Arrays.toString(runningSum(nums1))); // [1, 3, 6, 10]

        int[] nums2 = {1, 1, 1, 1, 1};
        System.out.println("Running Sum: " + Arrays.toString(runningSum(nums2))); // [1, 2, 3, 4, 5]

        int[] nums3 = {3, 1, 2, 10, 1};
        System.out.println("Running Sum: " + Arrays.toString(runningSum(nums3))); // [3, 4, 6, 16, 17]
    }
}
