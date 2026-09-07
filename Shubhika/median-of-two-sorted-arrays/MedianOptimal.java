// LeetCode 4 - Median of Two Sorted Arrays
// Approach: Optimal (Binary Search on the smaller array)
// Time Complexity: O(log(min(m, n))) | Space Complexity: O(1)

// IDEA:
// Instead of merging, use binary search to find the correct partition point.
//
// A median divides the combined array into two equal halves.
// We partition nums1 into LEFT and RIGHT parts.
// The remaining elements of the left half come from nums2.
//
// A valid partition satisfies:
//   maxLeft1 <= minRight2  AND  maxLeft2 <= minRight1
//
// If the condition is not met:
//   - maxLeft1 > minRight2 → we took too many from nums1 → move left
//   - maxLeft2 > minRight1 → we took too few  from nums1 → move right
//
// Always binary search on the SMALLER array for efficiency.

public class MedianOptimal {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            // Partition nums1 at mid1, nums2 at mid2
            int mid1 = (low + high) / 2;
            int mid2 = (m + n + 1) / 2 - mid1;

            // Elements just to the left and right of the partition in nums1
            int maxLeft1  = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minRight1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];

            // Elements just to the left and right of the partition in nums2
            int maxLeft2  = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int minRight2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Valid partition found!
                if ((m + n) % 2 == 1) {
                    // Odd total → median is the max of left halves
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // Even total → average of max(left) and min(right)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }

            } else if (maxLeft1 > minRight2) {
                // Too many elements from nums1 on the left → move left
                high = mid1 - 1;
            } else {
                // Too few elements from nums1 on the left → move right
                low = mid1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        MedianOptimal solution = new MedianOptimal();

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
        // Merged: [1,2,3,4] → median = 2.5

        System.out.println();

        // Test case 3
        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};
        System.out.println("Input:  nums1 = [0,0], nums2 = [0,0]");
        System.out.println("Output: " + solution.findMedianSortedArrays(nums5, nums6));
        // Merged: [0,0,0,0] → median = 0.0
    }
}
