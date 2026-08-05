import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        for(String word: strs) {
            char[] chars = word.toCharArray();
            
            Arrays.sort(chars);
            
            String sortedWord = new String(chars);

            map.computeIfAbsent(sortedWord, (key) -> new ArrayList<>()).add(word);
        }

        for(List<String> li: map.values()) {
            output.add(li);
        }

        return output;

    }
}
