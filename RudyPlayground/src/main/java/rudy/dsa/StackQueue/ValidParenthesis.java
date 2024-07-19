package rudy.dsa.StackQueue;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {

        int n = s.length();
        Stack<Character>stack = new Stack<>();
        for(int i= 0; i<n;i++){
            char currentChar = s.charAt(i);
            if(currentChar=='(' || currentChar=='{' || currentChar=='[')
                    stack.push(currentChar);
            else {
                if(stack.isEmpty())
                    return false;
                char top = stack.peek();
                if((currentChar=='}' && top!='{') || (currentChar==')' && top!='(')|| (currentChar==']' && top!='['))
                    return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = ")";
        ValidParenthesis obj = new ValidParenthesis();
        System.out.println(obj.isValid(s));
    }
}
