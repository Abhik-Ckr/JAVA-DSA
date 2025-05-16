//Given an integer array, find all unique triplets in the array that sums to zero.

import java.util.*;

public class Problem2 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // n log n

        for (int i = 0; i < nums.length; i++) { // o(n)
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) { // I think O(n)
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        List<List<Integer>> triplets = threeSum(nums);

        System.out.println(triplets);
    }
}

// Time complexity -> o(n log n) + o(n^2)
//space complexity -> o(1)