import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)-1);
        }

        for(Integer i: map.values()) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    }
}

/**

    Anagram is valid if t contains all the characters of s in same frequency.

 */
