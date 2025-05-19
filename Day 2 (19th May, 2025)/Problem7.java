// Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".

import java.util.*;

public class Problem7 {
    public static String LongestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];

        for(int i = 0; i < strs.length; i++){
            int j = 0;
            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of string");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] strs = new String[n];
        System.out.println("Enter the string : ");
        for(int i = 0; i < n; i++){
            strs[i] = scanner.nextLine();
        }
        String result = LongestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + (result.isEmpty() ? "No common prefix " : result));

        scanner.close();
    }
}
