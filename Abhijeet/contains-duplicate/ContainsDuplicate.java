import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            if(! set.add(nums[i])) return true;
        }       

        return false;
    }
}

/**
    Only require to hit duplicates, output only requires true/false.

    Requires info on what we already hit. (set)

 */