//  Given an array of integer and a target value, identify two numbers in the array that add up to the target value.

//approach -> sort then two pointes 

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // n log n
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // asking the array size 
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // asking for array elements
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }
}
// Time COmplexity : sorting -> o(n log n) and two pointer is taking -> o(n);


