package arrays;

import java.util.Arrays;

/**
 * LeetCode 283 - Move Zeroes (Easy)
 *
 * Problem: Given an integer array nums, move all 0s to the end while maintaining
 * the relative order of the non-zero elements. Do it in-place.
 *
 * Approach: Two-pointer — keep a slow pointer (insertPos) that tracks where the
 * next non-zero element should go. Walk the array with a fast pointer; whenever
 * a non-zero is found, place it at insertPos and advance insertPos.
 * Fill the rest of the array with zeros.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Place all non-zero elements at the front in order
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill remaining positions with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println("After moving zeroes: " + Arrays.toString(nums1)); // [1, 3, 12, 0, 0]

        int[] nums2 = {0, 0, 1};
        moveZeroes(nums2);
        System.out.println("After moving zeroes: " + Arrays.toString(nums2)); // [1, 0, 0]
    }
}
