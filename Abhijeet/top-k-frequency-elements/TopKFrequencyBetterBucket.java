import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequencyBetterBucket {
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxCount = 0;

        // Step 1: Build frequency map
        for (int num : nums) {
            int count = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, count);
            maxCount = Math.max(maxCount, count);
        }

        // Step 2: Build buckets (array of lists)\
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[maxCount + 1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }

        // Step 3: Collect top k elements
        int[] output = new int[k];
        int idx = 0;
        for (int i = maxCount; i >= 1 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    if (idx < k) {
                        output[idx++] = num;
                    } else break;
                }
            }
        }

        return output;
    }
}