/*
LeetCode 219 - Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct
indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5

Approach: Sliding Window + HashSet
- Maintain a HashSet of size at most k (a window of the last k elements).
- For each element, check if it already exists in the window.
  If yes, a nearby duplicate exists → return true.
- If the window exceeds size k, remove the oldest element (nums[i - k]).
- Time Complexity: O(n)
- Space Complexity: O(k)
*/

import java.util.HashSet;

class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            // keep the window size at most k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}
