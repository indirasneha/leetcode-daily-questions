class Log_2026_02_04 {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        
        // to prevent overflow during additions
        long INF = Long.MAX_VALUE / 4;
        
        long dp0 = nums[0];   // Start of 1st increasing
        long dp1 = -INF;      // In 1st increasing
        long dp2 = -INF;      // In 1st decreasing
        long dp3 = -INF;      // In 2nd increasing
        
        long maxTrionicSum = Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            long current = nums[i];
            long nextDp0, nextDp1, nextDp2, nextDp3;
            
            // Default reset
            nextDp0 = current;
            nextDp1 = -INF;
            nextDp2 = -INF;
            nextDp3 = -INF;

            if (nums[i] > nums[i - 1]) {
                // Phase 1: increasing
                nextDp1 = Math.max(dp1, dp0) + current;

                // Phase 3: increasing again
                if (dp2 != -INF || dp3 != -INF) {
                    nextDp3 = Math.max(dp3, dp2) + current;
                }
            } 
            else if (nums[i] < nums[i - 1]) {
                // Phase 2: decreasing
                if (dp1 != -INF || dp2 != -INF) {
                    nextDp2 = Math.max(dp2, dp1) + current;
                }
            }

            dp0 = nextDp0;
            dp1 = nextDp1;
            dp2 = nextDp2;
            dp3 = nextDp3;

            // Only dp3 is a valid completed trionic subarray
            if (dp3 != -INF) {
                maxTrionicSum = Math.max(maxTrionicSum, dp3);
            }
        }

        return maxTrionicSum;
    }
    public static void main(String[] args) {
        Log_2026_02_04 obj = new Log_2026_02_04();

        int[] nums1 = {0, -2, -1, -3, 0, 2, -1};
        System.out.println(obj.maxSumTrionic(nums1)); 

        int[] nums2 = {-754, 167, -172, 202, 735, -941, 992};
        System.out.println(obj.maxSumTrionic(nums2)); 
    }
}

