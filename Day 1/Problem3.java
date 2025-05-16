//Given an array, move all zeros to the end without changing the relative order of the non zero elements.
import java.util.*;

public class Problem3 {
    public static List<Integer> moveZerosToEnd(int[] nums){
        List<Integer> temp1 = new ArrayList<>(); //nonzeros
        List<Integer> temp2 = new ArrayList<>(); //zeros;
        List<Integer> temp3 = new ArrayList<>(); //result;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                temp2.add(nums[i]);
            }
            else{
                temp1.add(nums[i]);
            }
        }

        temp3.addAll(temp1);
        temp3.addAll(temp2);
        return temp3;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of element : ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements : ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        List<Integer> result = moveZerosToEnd(nums);

        System.out.println(result);

    }
}
