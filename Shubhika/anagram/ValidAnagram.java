/*
LeetCode 242 - Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.

Approach: Character Frequency Count
- If lengths differ, they can't be anagrams.
- Use an int array of size 26 (for a-z) to count character frequencies.
- Increment count for each character in s, decrement for each character in t.
- If all counts are zero at the end, t is an anagram of s.
- Time Complexity: O(n)
- Space Complexity: O(1) — fixed array of size 26
*/

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int freq : count) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        ValidAnagram solution = new ValidAnagram();

        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car"));         // false
    }
}
