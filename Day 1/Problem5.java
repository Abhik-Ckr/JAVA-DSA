// Rotate an array of n elements to the right by k steps

import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k <= 0) {
            return; 
        }

        k = k % n; 
    
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // Right shift
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of nums1: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Array size should be more than zero.");
            return;
        }

        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter value of k: ");
        int k = scanner.nextInt();

        rotate(nums, k);
        System.out.println("Rotated array: " + Arrays.toString(nums));
    }
}
