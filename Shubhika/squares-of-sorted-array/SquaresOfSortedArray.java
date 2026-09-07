// LeetCode 977 - Squares of a Sorted Array
// Approach: Two Pointers
// Time Complexity: O(n) | Space Complexity: O(n)

// IDEA:
// The input array is sorted, but has negative numbers.
// After squaring, the largest values can be at either end
// (e.g. [-4, -1, 0, 3, 10] → squares at ends: 16 and 100)
// So place one pointer at the LEFT and one at the RIGHT.
// Compare their squares → put the LARGER one at the END of result array.
// Move that pointer inward and repeat.

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left  = 0;
        int right = n - 1;
        int pos   = n - 1; 

        while (left <= right) {
            int leftSquare  = nums[left]  * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;  
            } else {
                result[pos] = rightSquare;
                right--;  
            }

            pos--;  
        }

        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray solution = new SquaresOfSortedArray();

        // Test case 1
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] res1  = solution.sortedSquares(nums1);
        System.out.println("Input:  [-4, -1, 0, 3, 10]");
        System.out.print("Output: [");
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i]);
            if (i < res1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        // Output: [0, 1, 9, 16, 100]

        System.out.println();

        // Test case 2
        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] res2  = solution.sortedSquares(nums2);
        System.out.println("Input:  [-7, -3, 2, 3, 11]");
        System.out.print("Output: [");
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i]);
            if (i < res2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        // Output: [4, 9, 9, 49, 121]
    }
}
