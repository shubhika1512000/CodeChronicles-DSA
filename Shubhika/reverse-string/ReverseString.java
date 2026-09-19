// LeetCode 344 - Reverse String
// Approach: Two Pointers
// Time Complexity: O(n) | Space Complexity: O(1)

// IDEA:
// Place one pointer at the start and one at the end.
// Swap the characters at both pointers.
// Move left pointer forward and right pointer backward.
// Stop when they meet in the middle.

public class ReverseString {

    public void reverseString(char[] s) {
        int left  = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters at left and right
            char temp = s[left];
            s[left]   = s[right];
            s[right]  = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();

        // Test case 1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Input:  ['h','e','l','l','o']");
        solution.reverseString(s1);
        System.out.print("Output: [");
        for (int i = 0; i < s1.length; i++) {
            System.out.print("'" + s1[i] + "'");
            if (i < s1.length - 1) System.out.print(",");
        }
        System.out.println("]");
        // Output: ['o','l','l','e','h']

        System.out.println();

        // Test case 2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.println("Input:  ['H','a','n','n','a','h']");
        solution.reverseString(s2);
        System.out.print("Output: [");
        for (int i = 0; i < s2.length; i++) {
            System.out.print("'" + s2[i] + "'");
            if (i < s2.length - 1) System.out.print(",");
        }
        System.out.println("]");
        // Output: ['h','a','n','n','a','H']
    }
}
