import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequnecyMergeSorted {
    
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort entries by frequency using custom merge sort
        List<Map.Entry<Integer, Integer>> sortedEntries =
            mergeSortEntries(new ArrayList<>(frequencyMap.entrySet()), 0, frequencyMap.size());

        // Step 3: Collect top k keys
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedEntries.get(i).getKey();
        }

        return result;
    }

    // Custom merge sort for Map.Entry<Integer, Integer> based on frequency
    private List<Map.Entry<Integer, Integer>> mergeSortEntries(
            List<Map.Entry<Integer, Integer>> entries, int start, int end) {

        // Base case: single element
        if (end - start == 1) {
            return Collections.singletonList(entries.get(start));
        }

        int mid = (start + end) / 2;

        // Recursive sort left and right halves
        List<Map.Entry<Integer, Integer>> left = mergeSortEntries(entries, start, mid);
        List<Map.Entry<Integer, Integer>> right = mergeSortEntries(entries, mid, end);

        // Merge two sorted halves
        return merge(left, right);
    }

    // Merge two lists sorted by frequency (descending)
    private List<Map.Entry<Integer, Integer>> merge(
            List<Map.Entry<Integer, Integer>> left, List<Map.Entry<Integer, Integer>> right) {

        List<Map.Entry<Integer, Integer>> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() || j < right.size()) {
            if (j < right.size() && (i == left.size() ||
                    left.get(i).getValue() < right.get(j).getValue())) {
                merged.add(right.get(j++));
            } else {
                merged.add(left.get(i++));
            }
        }

        return merged;
    }
}
