public class Main {

    static int max(int a, int b) {
        int res = 0;

        if(a > b) res = a;
        else res = b;

        return res;
    }

    static int optimum(int[] v, int[] s, int n, int i, int j, int[][] dp) {
        int res = 0;

        if(j <= 0) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(i < n && j >= s[i]) {
            int val1 = v[i] + optimum(v, s, n, i + 1, j - s[i], dp);
            int val2 = optimum(v, s, n, i + 1, j, dp);

            res = max(val1, val2);
        }

        dp[i][j] = res;

        return res;
    }

    static void init_dp(int[][] dp) {

        int n = dp.length;
        int m = n == 0 ? 0 : dp[0].length;

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                dp[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {

        // Number of items to take
        int n = 8;

        // Capacity of the backpack
        int M = 12;

        // Value of the n items
        int[] v = {25, 20, 15, 40, 50, 55, 45, 58};

        // Weight of the n items
        int[] s = {3, 2, 1, 4, 5, 9, 6, 7};

        // Declare and initialize memo table
        int[][] dp = new int[n + 1][M + 1];

        init_dp(dp);

        // Compute max revenue
        int i = 0;
        int j = M;

        int max_rev = optimum(v, s, n, i, j, dp);

        // Print results
        System.out.println("max revenue: " + max_rev);
    }
}