import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;

        for(int val: set) {
            if(! set.contains(val-1)) {
                int length = 1;

                while(set.contains(val + length)) length++;

                longest = Math.max(longest, length);
            }
        }

        return longest;
        
    }
}