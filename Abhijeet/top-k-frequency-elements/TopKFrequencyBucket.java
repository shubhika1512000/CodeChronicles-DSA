import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TopKFrequencyBucket {

    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        
        Map<Integer, Set<Integer>> bucketMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        int maxCount = Integer.MIN_VALUE;

        for(int i=0; i < nums.length; i++) {
            int newCount_i = freqMap.getOrDefault(nums[i], 0) + 1;

            maxCount = Math.max(newCount_i, maxCount);

            freqMap.put(nums[i], newCount_i);

            if(newCount_i == 1) 
                bucketMap.computeIfAbsent(newCount_i, (key)->new HashSet<Integer>())
                    .add(nums[i]);
            else {
                bucketMap.computeIfAbsent(newCount_i-1, (key)->new HashSet<Integer>())
                    .remove(nums[i]);

                bucketMap.computeIfAbsent(newCount_i, (key)->new HashSet<Integer>())
                    .add(nums[i]);
            }
        }

        while( maxCount > 0 && k > 0) {
            Set<Integer> set = 
                bucketMap.getOrDefault(maxCount, new HashSet<Integer>());
            
            for(int num: set) {
                if(k > 0) output[k-1] = num;
                else break;
                    
                k--;
            }

            maxCount--;
        }

        return output;
    }
}

/***
    It has to do with frequency: 
        - store frequency in hashmap

    1 2 1, k=2,  1 2 

    1 2 3 3 4 4, k=2, 3 4 1 2

    How maxCount and complexity works 
    maxCount increases with the freq of number, 
        if same number repeted all the time then others iterations for say n-1 iterations + 1(nth * number of elements in set)  

    What ever the maxCount value is the number of iterations are bounded by 
    number of elements can't exceed n, O(n)

    Total: O(n)
 */