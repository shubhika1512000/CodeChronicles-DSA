import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        // set the eligible window
        for(int i = 0; i<=k && i < nums.length; i++) {
            if(! set.add(nums[i])) return true;
        }

        for(int i = k+1; i < nums.length; i++) {
            set.remove(nums[i-(k+1)]);

            if(! set.add(nums[i])) return true;
        }

        return false;

    }
}


/**

    Rule: ( i-j <= k || j-i <= k ) && nums[i] == nums[j] && i != j
    -
    --
    ---

    maxwindow allowed is size k, we have a size restricted hashmap with atmost k+1 elements,

    let say if k = 2
    i = 0 , j = 1, 2; 

    if k = 0
    i = 0, j = 0 but i!=j 

    true if we ever get a hit on our hashmap in our loop, 





*/
