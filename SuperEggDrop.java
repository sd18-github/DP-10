/*
 * TC: O(k*n)
 * SC: O(k)
 */
public class SuperEggDrop {
    /*
     This is a dynamic programming solution to the Super Egg Drop problem.
     The idea is to use a 1D dp array where dp[i] represents the maximum number of floors
     that can be tested with i eggs and a certain number of drops.
     The outer loop iterates over the number of drops, and the inner loop iterates over the number of eggs.
     The dp array is updated in reverse order to avoid overwriting the values that are needed for the current iteration.
     The while loop continues until the maximum number of floors that can be tested with k eggs is less than n.
     The final result is the number of attempts needed to find the critical floor.
    */
    public int superEggDrop(int k, int n) {
        // dp[x] stores maximum number of floors that can be tested
        // using x eggs and a certain number of drops
        int[] dp = new int[k + 1];
        int attempts = 0;

        // iterate until max floors that can be checked by k eggs < total no of floors
        while(dp[k] < n) {
            attempts++;
            for(int j = k; j > 0; j--) {
                // 1 is for current drop attempt
                // dp[j-1] is the case where jth egg breaks
                // dp[j] is the case where jth egg does not break
                dp[j] = 1 + dp[j - 1] + dp[j];
            }
        }
        return attempts;
    }
}
/*
    This is a dp solution with O(k*n^2) time complexity and O(k*n) space complexity.
    The idea is to use a 2D dp array where dp[i][j] represents the minimum number of attempts needed
    to find the critical floor with i eggs and j floors.
    The base case is when we have only one egg, in which case we need j attempts for j floors.
    If we have 0 floors, we need 0 attempts, and if we have 1 floor, we need 1 attempt.
    The recurrence relation is as follows:
    dp[i][j] = min(1 + max(dp[i - 1][f - 1], dp[i][j - f])) for all f in [1, j]
    where f is the floor we drop the egg from.

    However, this solution is not optimal and can be improved to O(k*n) time complexity,
    as done in the above code.

     int[][] dp = new int[k + 1][n + 1];
     for(int j = 1; j <= n; j++) {
         dp[1][j] = j;
     }
     for(int i = 2; i <= k; i++) {
         for(int j = 1; j <= n; j++) {
             dp[i][j] = Integer.MAX_VALUE;
             for(int f = 1; f <= j; f++) {
                 dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f]));
             }
         }
     }
     return dp[k][n];
 */
