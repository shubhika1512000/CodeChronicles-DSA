// LeetCode 49 - Group Anagrams
// Approach: Sort each word and use it as a HashMap key
// Time Complexity: O(n * k log k) — n = number of words, k = max word length
// Space Complexity: O(n * k)

// IDEA:
// Anagrams always produce the same string when their characters are sorted.
// e.g. "eat", "tea", "ate" → all sort to "aet"
// So sort each word → use sorted word as key in a HashMap → group originals together.

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // key   = sorted version of the word
        // value = list of original words that match this key
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Sort the characters of the word to form the key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // If key not present, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add original word to its group
            map.get(key).add(word);
        }

        // Return all grouped lists
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        // Test case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input:  [eat, tea, tan, ate, nat, bat]");
        System.out.println("Output: " + solution.groupAnagrams(strs1));
        // Output: [[eat, tea, ate], [tan, nat], [bat]]

        System.out.println();

        // Test case 2
        String[] strs2 = {""};
        System.out.println("Input:  [\"\"]");
        System.out.println("Output: " + solution.groupAnagrams(strs2));
        // Output: [[]]

        System.out.println();

        // Test case 3
        String[] strs3 = {"a"};
        System.out.println("Input:  [a]");
        System.out.println("Output: " + solution.groupAnagrams(strs3));
        // Output: [[a]]
    }
}
