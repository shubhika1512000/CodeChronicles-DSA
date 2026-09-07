// LeetCode 4 - Median of Two Sorted Arrays
// Approach: Brute Force (Merge both arrays, then find median)
// Time Complexity: O(m + n) | Space Complexity: O(m + n)

// IDEA:
// Step 1: Merge both sorted arrays into one sorted array (like merge sort)
// Step 2: Find the median from the merged array
//   - If total length is ODD  → middle element
//   - If total length is EVEN → average of two middle elements

public class MedianBruteForce {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        // Step 1: Merge both arrays into one sorted array
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements of nums1
        while (i < m) merged[k++] = nums1[i++];

        // Copy remaining elements of nums2
        while (j < n) merged[k++] = nums2[j++];

        // Step 2: Find median
        int total = m + n;

        if (total % 2 == 1) {
            // Odd total → return the middle element
            return merged[total / 2];
        } else {
            // Even total → return average of two middle elements
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianBruteForce solution = new MedianBruteForce();

        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Input:  nums1 = [1,3], nums2 = [2]");
        System.out.println("Output: " + solution.findMedianSortedArrays(nums1, nums2));
        // Merged: [1,2,3] → median = 2.0

        System.out.println();

        // Test case 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Input:  nums1 = [1,2], nums2 = [3,4]");
        System.out.println("Output: " + solution.findMedianSortedArrays(nums3, nums4));
        // Merged: [1,2,3,4] → median = (2+3)/2 = 2.5
    }
}
