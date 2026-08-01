import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int find = target - nums[i];

            int dofind = map.getOrDefault(find, -1);
            if ( dofind != -1 ) {
                output[0] = dofind;
                output[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return output;
    }
}