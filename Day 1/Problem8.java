//Given an integer array, find the contiguous subarray that has the largest product.
import java.util.*;

public class Problem8 {
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            int tempMax = maxProd;

            maxProd = Math.max(current, Math.max(current * maxProd, current * minProd));
            minProd = Math.min(current, Math.min(current * tempMax, current * minProd));

            result = Math.max(result, maxProd);
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

        int maxProduct = maxProduct(nums);
        System.out.println("Maximum product subarray: " + maxProduct);
    }
}
