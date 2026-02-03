class Log_2026_02_03 {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
       
        for (int p = 1; p <= n - 3; p++) {
          
            for (int q = p + 1; q <= n - 2; q++) {
                
                boolean valid = true;
                
                for (int i = 0; i < p; i++) {
                    if (nums[i] >= nums[i + 1]) {
                        valid = false;
                        break;
                    }
                }
                
                if (!valid) continue;
                
                for (int i = p; i < q; i++) {
                    if (nums[i] <= nums[i + 1]) {
                        valid = false;
                        break;
                    }
                }
                
                if (!valid) continue;
               
                for (int i = q; i < n - 1; i++) {
                    if (nums[i] >= nums[i + 1]) {
                        valid = false;
                        break;
                    }
                }
                
                if (valid) return true;
            }
        }
        
        return false;
    }
public static void main(String[] args) {
        Log_2026_02_03 obj = new Log_2026_02_03();
        int[] nums = {1, 3, 5, 4, 2, 6};
        System.out.println(obj.isTrionic(nums)); // true
    }
}
