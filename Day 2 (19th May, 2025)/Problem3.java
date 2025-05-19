//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid

import java.util.Scanner;
import java.util.Stack;

public class Problem3 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) return false;
                char top = st.peek();
                if ((ch == ')' && top == '(') || 
                    (ch == ']' && top == '[') || 
                    (ch == '}' && top == '{')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem3 sol = new Problem3();

        System.out.print("Enter a string of brackets: ");
        String input = scanner.nextLine();

        boolean result = sol.isValid(input);

        if (result) {
            System.out.println("The string is valid.");
        } else {
            System.out.println("The string is invalid.");
        }

        scanner.close();
    }
}
