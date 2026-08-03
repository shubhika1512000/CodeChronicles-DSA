import java.util.TreeSet;

class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++) {
            // this is for window strictness
            if(i > indexDiff) set.remove(nums[i - indexDiff - 1]);
            
            int findfloor = nums[i] + valueDiff; 
            int satisfyCeil = nums[i] - valueDiff;
            
            Integer floor = set.floor(findfloor);

            if(floor != null && floor >= satisfyCeil) return true;

            set.add(nums[i]);
            
        }

        return false;

    }
}

/**
    The pairs can be maximum indexDiff apart,

    we need hashset, to track the visited values, the memory should be strictly no more than indexDiff apart
        i-j <= indexDiff


    +|-(nums[i] - nums[j]) <= valueDiff

    nums[i] <= nums[j] + valueDiff &&
    nums[i] >= nums[j] - valueDiff


 */