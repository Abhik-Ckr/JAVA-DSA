//Given a string, find the length of the longest substring without repeating characters

import java.util.HashSet;
import java.util.Scanner;

public class Problem9 {
    public static int lengthOfLongestSubString(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;

        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int result = lengthOfLongestSubString(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);

        scanner.close();
    }
}
