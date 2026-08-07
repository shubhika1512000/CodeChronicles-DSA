package arrays;

/**
 * LeetCode 136 - Single Number (Easy)
 *
 * Problem: Given a non-empty array where every element appears twice except for one,
 * find and return that single element.
 *
 * Approach: XOR all elements together. XOR of a number with itself is 0, and XOR
 * with 0 returns the number itself. So all duplicate pairs cancel out, leaving
 * only the unique element.
 *   e.g. [4, 1, 2, 1, 2]  →  4^1^2^1^2 = 4^(1^1)^(2^2) = 4^0^0 = 4
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num; // XOR cancels out pairs
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        System.out.println("Single Number: " + singleNumber(nums1)); // Output: 1

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Single Number: " + singleNumber(nums2)); // Output: 4

        int[] nums3 = {1};
        System.out.println("Single Number: " + singleNumber(nums3)); // Output: 1
    }
}
