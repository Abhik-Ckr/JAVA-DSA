//Two strings are considered close if you can swap letters or change the frequency of any letter to match the other string. Determine if two given strings are close

import java.util.*;

public class Problem5 {
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (char c : word1.toCharArray()) {
            set1.add(c);
        }
        for (char c : word2.toCharArray()) {
            set2.add(c);
        }

        if (!set1.equals(set2)) {
            return false;
        }

        Map<Character, Integer> mpp1 = new HashMap<>();
        Map<Character, Integer> mpp2 = new HashMap<>();

        for (char c : word1.toCharArray()) {
            mpp1.put(c, mpp1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            mpp2.put(c, mpp2.getOrDefault(c, 0) + 1);
        }

        List<Integer> count1 = new ArrayList<>(mpp1.values());
        List<Integer> count2 = new ArrayList<>(mpp2.values());

        Collections.sort(count1);
        Collections.sort(count2);

        return count1.equals(count2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first word:");
        String word1 = sc.nextLine();

        System.out.println("Enter second word:");
        String word2 = sc.nextLine();

        boolean result = closeStrings(word1, word2);

        if (result) {
            System.out.println("The words are close strings. -> TRUE");
        } else {
            System.out.println("The words are NOT close strings. -> FALSE");
        }

        sc.close();
    }
}
