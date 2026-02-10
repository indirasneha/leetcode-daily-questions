import java.util.HashSet;
import java.util.Set;

public class Log_2026_02_10 {

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> evens = new HashSet<>();
            Set<Integer> odds = new HashSet<>();

            for (int j = i; j < n; j++) {
                if ((nums[j] & 1) == 0) {
                    evens.add(nums[j]);
                } else {
                    odds.add(nums[j]);
                }

                if (evens.size() == odds.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Log_2026_02_10 obj = new Log_2026_02_10();

        int[] nums1 = {2, 5, 4, 3};
        System.out.println(obj.longestBalanced(nums1)); 

        int[] nums2 = {3, 2, 2, 5, 4};
        System.out.println(obj.longestBalanced(nums2)); 

        int[] nums3 = {1, 2, 3, 2};
        System.out.println(obj.longestBalanced(nums3)); 
    }
}
