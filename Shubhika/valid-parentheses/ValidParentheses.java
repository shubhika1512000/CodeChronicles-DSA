/*
LeetCode 20 - Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

A string is valid if:
- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([)]"
Output: false

Constraints:
1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.

Approach: Stack
- Traverse each character in the string.
- If it's an opening bracket, push it onto the stack.
- If it's a closing bracket, check if the top of the stack is its matching opener.
  - If yes, pop the top.
  - If no (or stack is empty), return false.
- At the end, stack must be empty for the string to be valid.
- Time Complexity:  O(n)
- Space Complexity: O(n)
*/

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // closing bracket — stack must have a matching opener on top
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // valid only if all openers were matched and closed
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        ValidParentheses solution = new ValidParentheses();

        System.out.println(solution.isValid("()"));       // true
        System.out.println(solution.isValid("()[]{}"));   // true
        System.out.println(solution.isValid("(]"));       // false
        System.out.println(solution.isValid("([)]"));     // false
        System.out.println(solution.isValid("{[]}"));     // true
    }
}
