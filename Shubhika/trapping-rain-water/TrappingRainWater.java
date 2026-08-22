/*
LeetCode 42 - Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
1 <= n <= 2 * 10^4
0 <= height[i] <= 10^5

Approach: Two Pointers
- Use a left and right pointer starting from both ends.
- Track maxLeft and maxRight — the highest bar seen so far from each side.
- Water trapped at any position = min(maxLeft, maxRight) - height[current]
- Move the pointer with the smaller max inward, because the shorter side
  is the limiting factor for water at that position.
- Time Complexity:  O(n)
- Space Complexity: O(1)
*/

public class TrappingRainWater {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxLeft = height[left];
        int maxRight = height[right];

        int water = 0;

        while (left < right) {

            if (maxLeft <= maxRight) {
                // left side is the limiting factor
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                water += maxLeft - height[left];
            } else {
                // right side is the limiting factor
                right--;
                maxRight = Math.max(maxRight, height[right]);
                water += maxRight - height[right];
            }
        }

        return water;
    }

    public static void main(String[] args) {

        TrappingRainWater solution = new TrappingRainWater();

        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(solution.trap(new int[]{4, 2, 0, 3, 2, 5}));                   // 9
    }
}
