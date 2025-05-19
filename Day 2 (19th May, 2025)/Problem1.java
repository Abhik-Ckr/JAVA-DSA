//Given an array of strings, group anagrams together.
// vector<vector<string>> groupAnagrams(vector<string>& strs) {
//     unordered_map<string, vector<string>> mpp;

//     for(const string& str : strs){
//         string sortedStr = str;
//         sort(sortedStr.begin(), sortedStr.end());
//         mpp[sortedStr].push_back(str);
//     }
//     vector<vector<string>> result;
//         for(auto it : mpp){
//             result.push_back(it.second);
//     }
//     return result;
// }

import java.util.*;

public class Problem1 {
    public static List<List<String>> groupAnagram(String[] strs){
        Map<String, List<String>> mpp = new HashMap<>();

        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            mpp.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(mpp.values());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        String[] input = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextLine();
        }

        List<List<String>> result = groupAnagram(input);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }

        scanner.close();
    }
}
