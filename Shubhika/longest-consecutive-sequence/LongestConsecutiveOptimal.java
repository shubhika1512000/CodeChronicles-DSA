// LeetCode 128 - Longest Consecutive Sequence
// Approach: Optimal using HashSet
// Time Complexity: O(n) | Space Complexity: O(n)

// IDEA:
// Put all numbers into a HashSet for O(1) lookup.
// A number is the START of a sequence only if (num - 1) does NOT exist in the set.
// From each sequence start, count how far the streak goes (num+1, num+2, ...).
// This way, each number is visited at most twice → O(n) overall.

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveOptimal {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Add all numbers to a HashSet
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;

        for (int num : set) {
            // Only start counting if num is the beginning of a sequence
            // i.e. num-1 does NOT exist in the set
            if (!set.contains(num - 1)) {
                int current = num;
                int streak = 1;

                // Extend the streak as far as possible
                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveOptimal solution = new LongestConsecutiveOptimal();

        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Input:  [100, 4, 200, 1, 3, 2]");
        System.out.println("Output: " + solution.longestConsecutive(nums1));
        // Output: 4  (sequence: 1, 2, 3, 4)

        System.out.println();

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Input:  [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]");
        System.out.println("Output: " + solution.longestConsecutive(nums2));
        // Output: 9  (sequence: 0, 1, 2, 3, 4, 5, 6, 7, 8)
    }
}
