//Given a string ss, return the longest palindromic substring in ss.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        Map<String, Boolean> palindromeMap = new HashMap<>();
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);

                if (!palindromeMap.containsKey(sub)) {
                    palindromeMap.put(sub, isPalindrome(sub));
                }

                if (palindromeMap.get(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }

        return longest;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = longestPalindrome(input);

        System.out.println("Longest Palindromic Substring: " + result);

        scanner.close();
    }
}
