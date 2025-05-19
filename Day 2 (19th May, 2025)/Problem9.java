// Given a string s consisting of words and spaces, return the length of the last word in the string. A word is a maximal substring consisting of non-space characters only.

import java.util.*;

public class Problem9 {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }


    public static void main(String[] args) {
        Problem9 sol = new Problem9();

        System.out.println(sol.lengthOfLastWord("Hello World"));         // Output: 5
        System.out.println(sol.lengthOfLastWord(" fly me to the moon ")); // Output: 4
        System.out.println(sol.lengthOfLastWord("luffy is still joyboy")); // Output: 6
    }
}
