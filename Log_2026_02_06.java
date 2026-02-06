import java.util.Arrays;

public class Log_2026_02_06 {

    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int minRemovals = n;
        int right = 0;

        // Sliding window
        for (int left = 0; left < n; left++) {

            while (right < n && nums[right] <= (long) nums[left] * k) {
                right++;
            }

            int windowSize = right - left;
            minRemovals = Math.min(minRemovals, n - windowSize);
        }

        return minRemovals;
    }

    public static void main(String[] args) {
        Log_2026_02_06 obj = new Log_2026_02_06();

        int[] nums1 = {2, 1, 5};
        int k1 = 2;
        System.out.println(obj.minRemoval(nums1, k1)); 

        int[] nums2 = {1, 6, 2, 9};
        int k2 = 3;
        System.out.println(obj.minRemoval(nums2, k2)); 

        int[] nums3 = {4, 6};
        int k3 = 2;
        System.out.println(obj.minRemoval(nums3, k3)); 
    }
}
