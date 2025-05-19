//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack

import java.util.Scanner;

public class Problem8 {
    public static int findingNeedleInAHaystack(String haystack, String needle){
        if(needle.isEmpty()){
            return 0;
        }
        int hlen = haystack.length();
        int nlen = needle.length();

        for (int i = 0; i <= hlen - nlen; i++) {
            if (haystack.substring(i, i + nlen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter haystack string: ");
        String haystack = scanner.nextLine();

        System.out.print("Enter needle string: ");
        String needle = scanner.nextLine();

        int index = findingNeedleInAHaystack(haystack, needle);
        System.out.println("Output: " + index);

        scanner.close();
    }
}
