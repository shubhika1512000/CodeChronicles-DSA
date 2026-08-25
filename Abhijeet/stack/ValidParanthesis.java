import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i= 0; i < s.length(); i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){ 
                stk.push(s.charAt(i));
            } // adding only when we encounter open bracket

            else {
                if(stk.isEmpty()) {
                    return false;
                } // if we don't have any open bracket before comming here.

                if(stk.peek() == '(' && s.charAt(i)==')') {
                    stk.pop();
                }
                else if(stk.peek() == '[' && s.charAt(i)==']') {
                    stk.pop();
                }
                else if(stk.peek() == '{' && s.charAt(i)=='}') {
                    stk.pop();
                } else { 
                    return false;
                } // if any other condition then it's over like on this ( we got }
            }
        }

        if(stk.isEmpty()) return true; // if stack completely empty
        
        return false; // if not
    }
}