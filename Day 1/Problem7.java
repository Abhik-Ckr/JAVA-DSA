//Given an integer array, find the contiguous subarray that has the largest sum. 


import java.util.*;

public class Problem7 {
   public static int maxSubArray(int[] nums) {
        int maxiSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxiSum =Math.max(maxiSum, currentSum);
        }
        return maxiSum;
   } 

   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number of element : ");
    int n = scanner.nextInt();
    int[] nums = new int[n];

    System.out.println("Enter the elements : ");
    for(int i = 0; i < n; i++){
        nums[i] = scanner.nextInt();
    }

    int maxSum = maxSubArray(nums);
    System.out.println("The maximum subarray sum : ");
    System.out.println(maxSum);
   }
}
