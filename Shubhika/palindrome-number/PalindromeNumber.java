// LeetCode #9 - Palindrome Number
// https://leetcode.com/problems/palindrome-number/
//
// Given an integer x, return true if x is a palindrome, and false otherwise.
//
// Example 1: Input: x = 121  -> Output: true
// Example 2: Input: x = -121 -> Output: false
// Example 3: Input: x = 10   -> Output: false
//
// Approach: Convert to string, use two pointers from both ends
// Time Complexity:  O(n) - n is the number of digits
// Space Complexity: O(n) - for the string conversion

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes
        if (x < 0) return false;

        String s = Integer.toString(x);
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();

        System.out.println(sol.isPalindrome(121));   // true
        System.out.println(sol.isPalindrome(-121));  // false
        System.out.println(sol.isPalindrome(10));    // false
        System.out.println(sol.isPalindrome(0));     // true
        System.out.println(sol.isPalindrome(1221));  // true
    }
}
