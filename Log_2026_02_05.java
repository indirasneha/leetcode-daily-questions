class Log_2026_02_05 {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[(((i + nums[i]) % n) + n) % n];
        }
        return res;
    }

    public static void main(String[] args) {
        Log_2026_02_05 obj = new Log_2026_02_05();

        int[] nums1 = {3, -2, 1, 1};
        int[] res1 = obj.constructTransformedArray(nums1);
        for (int x : res1) System.out.print(x + " ");
        System.out.println(); 

        int[] nums2 = {-1, 4, -1};
        int[] res2 = obj.constructTransformedArray(nums2);
        for (int x : res2) System.out.print(x + " ");
        System.out.println(); 
    }
}
