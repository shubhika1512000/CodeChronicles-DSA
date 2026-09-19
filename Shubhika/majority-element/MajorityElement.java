// LeetCode 169 - Majority Element
// Approach: Boyer-Moore Voting Algorithm
// Time Complexity: O(n) | Space Complexity: O(1)

// IDEA:
// The majority element appears MORE than n/2 times.
// Think of it as a vote — every time you see the same number, +1 vote.
// Every time you see a different number, -1 vote (they cancel out).
// The majority element can never be fully cancelled out, so it always survives.

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                // No current candidate, pick this element
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                // Same as candidate → gain a vote
                count++;
            } else {
                // Different → cancel one vote
                count--;
            }
        }

        return candidate; // guaranteed to be the majority element
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        // Test case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Input:  [3, 2, 3]");
        System.out.println("Output: " + solution.majorityElement(nums1));
        // Output: 3

        System.out.println();

        // Test case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Input:  [2, 2, 1, 1, 1, 2, 2]");
        System.out.println("Output: " + solution.majorityElement(nums2));
        // Output: 2
    }
}
