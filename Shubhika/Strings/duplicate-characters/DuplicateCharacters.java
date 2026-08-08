package strings;

/**
 * TODO: Find Duplicate Characters in a String
 *
 * Problem: Given a string, find all characters that appear more than once.
 *
 * Approach: Use a frequency map (HashMap) to count occurrences,
 * then print characters whose count > 1.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1) — at most 26 lowercase letters
 */
public class DuplicateCharacters {

    public static void findDuplicates(String str) {
        // TODO: implement
    }

    public static void main(String[] args) {
        findDuplicates("programming"); // expected: r, g, m
    }
}
