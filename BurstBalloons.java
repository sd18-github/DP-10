public class BurstBalloons {
    /*
     This is a dynamic programming solution to the Burst Balloons problem.
     The idea is to use a 2D dp array where dp[i][j] represents the maximum coins
     that can be obtained by bursting all the balloons between index i and j.
     The outer loop iterates over the length of the subarray, and the inner loop iterates over the starting index.
     The left and right variables represent the values of the balloons adjacent to the current subarray.
     The innermost loop iterates over the index of the balloon to be burst,
     and calculates the maximum coins that can be obtained by bursting that balloon.
     The final result is stored in dp[0][n - 1], which represents the maximum coins that can be obtained
    */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        // Iterate over the lengths of the subarrays
        for(int len = 1; len <= n; len++) {
            // Iterate over the starting index of the subarray
            for(int i = 0; i <= n - len; i++) {
                // Calculate the ending index of the subarray
                int j = i + len - 1;

                // get the balloons to the left and right of the current subarray
                int left = i > 0 ? nums[i - 1] : 1;
                int right = j < (n - 1) ? nums[j + 1] : 1;

                for(int k = i; k <= j; k++) {

                    // Calculate the maximum coins that can be obtained by bursting the balloon at index k
                    int before = k > i ? dp[i][k - 1] : 0;
                    int after = k < j ? dp[k + 1][j] : 0;
                    int value = before + left * nums[k] * right + after;

                    dp[i][j] = Math.max(value, dp[i][j]);
                }
            }
        }
        // The final result is stored in dp[0][n - 1], which represents the maximum coins that can be obtained
        return dp[0][n - 1];
    }
}
