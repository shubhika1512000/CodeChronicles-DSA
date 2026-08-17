import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class TopFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;

       for(String word: words) {  // n
            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);

            max = Math.max(max, count);
        }

        TreeSet<String>[] buckets = new TreeSet[max+1];
        
        for(String key: map.keySet()) { // 1 => [] n log n 
            int freq = map.get(key);
            if(buckets[freq] == null) 
                buckets[freq] = new TreeSet<String>();
            
            buckets[freq].add(key);
        }

        List<String> finalSet = new ArrayList<>();

        while(finalSet.size() < k) { // klogk

            while( buckets[max] !=null 
                && (! buckets[max].isEmpty()) 
                && finalSet.size() < k){
                finalSet.add(buckets[max].pollFirst());
            }

            max--;
        }
        
        return finalSet;
    }
}

/**
    Same Bucket Strategy
 */