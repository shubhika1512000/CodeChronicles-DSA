// LeetCode 238 - Product of Array Except Self
// Approach: Prefix and Suffix products (no division)
// Time Complexity: O(n) | Space Complexity: O(1) extra (output array not counted)

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Fill result with prefix products
        // result[i] = product of all elements to the LEFT of i
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply each position with suffix product
        // suffix tracks the running product of elements to the RIGHT of i
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] res1 = solution.productExceptSelf(nums1);
        System.out.print("Input:  [1, 2, 3, 4]");
        System.out.println();
        System.out.print("Output: [");
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i]);
            if (i < res1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        // Output: [24, 12, 8, 6]

        System.out.println();

        // Test case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] res2 = solution.productExceptSelf(nums2);
        System.out.print("Input:  [-1, 1, 0, -3, 3]");
        System.out.println();
        System.out.print("Output: [");
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i]);
            if (i < res2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        // Output: [0, 0, 9, 0, 0]
    }
}
