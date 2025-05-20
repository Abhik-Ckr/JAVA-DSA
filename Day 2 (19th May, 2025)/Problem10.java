// Given a string paragraph and a string array of the banned words banned, return the most frequent word 
// that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is 
// unique.
// The words in paragraph are case-insensitive and the answer should be returned in lowercase
import java.util.*;

public class Problem10 {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = paragraph.split("\\s+");

        String mostCommon = "";
        int maxCount = 0;

        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }

            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

            if (wordCount.get(word) > maxCount) {
                maxCount = wordCount.get(word);
                mostCommon = word;
            }
        }

        return mostCommon;
    }
    public class Main {
        public static void main(String[] args) {
            Problem10 solution = new Problem10();
    
            String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
            String[] banned = {"hit"};
    
            String result = solution.mostCommonWord(paragraph, banned);
            System.out.println("Most common non-banned word: " + result);
        }
    }
    
}

