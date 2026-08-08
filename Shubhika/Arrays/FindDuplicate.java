package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 287 - Find the Duplicate Number (Medium)
 *
 * Problem: Given an array nums of n + 1 integers where each value is in range [1, n],
 * there is exactly one duplicate number. Find and return it.
 *
 * Example:
 *   Input : [1, 3, 4, 2, 2]
 *   Output: 2
 *
 *   Input : [3, 1, 3, 4, 2]
 *   Output: 3
 *
 * Approach: HashSet
 *   - Iterate through the array.
 *   - Try to add each number to the HashSet.
 *   - If add() returns false, the number is already present — that's the duplicate.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {  // add() returns false if element already exists
                return num;        // duplicate found
            }
        }

        return -1; // should never reach here given valid input
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate: " + findDuplicate(nums1)); // Output: 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate: " + findDuplicate(nums2)); // Output: 3

        int[] nums3 = {1, 1};
        System.out.println("Duplicate: " + findDuplicate(nums3)); // Output: 1
    }
}
