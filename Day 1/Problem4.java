// Given two arrays, find the intersection of their elements, including duplicate elements
import java.util.*;

public class Problem4 {
    public static List<Integer> intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mpp = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums1) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1); // mpp[num]++;
        }

        for (int num : nums2) {
            if (mpp.containsKey(num) && mpp.get(num) > 0) {
                result.add(num);
                mpp.put(num, mpp.get(num) - 1); // mpp[num]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // nums1
        System.out.println("Enter the size of nums1: ");
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter the elements of nums1: ");
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }

        // nums2
        System.out.println("Enter the size of nums2: ");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter the elements of nums2: ");
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt(); 
        }

        List<Integer> intersections = intersect(nums1, nums2);

        System.out.println("Intersection of the arrays: " + intersections);
    }
}
