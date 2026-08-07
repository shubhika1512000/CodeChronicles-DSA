import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {
    public int countAnagrams(String s) {
        String[] words = s.split(" ");
        long finalCount = 1;

        for(String word: words) {
            Map<Character, Long> map = new HashMap<>();
            long prevCount = 1;
            for(int i = 0; i < word.length(); i++) {
                long count = map.getOrDefault(word.charAt(i), 0L);
                
                long temp = (prevCount * (i + 1)) ;
                count = count + 1;
                prevCount = (temp / count) % 1000_000_007L;

                map.put(word.charAt(i), count);
            }

            finalCount = ((finalCount % 1000_000_007L) * (prevCount % 1000_000_007L)) % 1000_000_007L;
        }

        return (int)finalCount;
    }
}

// a = 1
// ab = a.2
// abc = ab.3
// abcc = abc.4/2
// abccd = abcc.5
// abccdc = abccd.6/3 => 6!/ 3!
// abccdcd = abccdc.7/2 => 7!/3!2!

// The logic is correct but the code has mistake in : prevCount = (temp / count) % 1000_000_007L; assuming that temp is always completely divisible by count is the mistake. 

