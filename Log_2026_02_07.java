public class Log_2026_02_07 {

    public int minimumDeletions(String s) {
        int n = s.length();
        int[] prefixB = new int[n + 1];
        int[] suffixA = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixB[i + 1] = prefixB[i] + (s.charAt(i) == 'b' ? 1 : 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixA[i] = suffixA[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }

        int ans = n;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, prefixB[i] + suffixA[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Log_2026_02_07 obj = new Log_2026_02_07();

        System.out.println(obj.minimumDeletions("aababbab"));   
        System.out.println(obj.minimumDeletions("bbaaaaabb")); 
        System.out.println(obj.minimumDeletions("aaaa"));      
        System.out.println(obj.minimumDeletions("bbbb"));      
    }
}
