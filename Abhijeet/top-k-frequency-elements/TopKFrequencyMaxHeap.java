import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequencyMaxHeap {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Step 1: Build frequency map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: MinHeap ordered by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Keep heap size <= k
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove least frequent
            }
        }

        // Step 4: Extract results
        int[] output = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            output[idx++] = minHeap.poll().getKey();
        }

        return output;
    }
}
