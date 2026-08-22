/*
LeetCode 14 - Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

Approach: Horizontal Scanning
- Take the first string as the initial prefix.
- Compare it with each subsequent string one by one.
- Keep trimming the prefix from the end until it matches the start of the current string.
- If prefix becomes empty at any point, return "".
- Time Complexity:  O(n * m) where n = number of strings, m = length of shortest string
- Space Complexity: O(1)
*/

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            // trim prefix until current string starts with it
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {

        LongestCommonPrefix solution = new LongestCommonPrefix();

        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // "fl"
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));    // ""
    }
}
