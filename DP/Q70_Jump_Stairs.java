class Solution {
    public int climbStairs(int n) {
        int [] arr = new int[n];
        if(n == 1) return 1;
        arr[0] = 1;
        arr[1] = 2;

        for(int i = 2; i < n; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n-1];
    }
}

// class Solution {
//     public int climbStairs(int n) {
//         int [] dp = new int[n + 1];
//         dp[0] = 1;
//
//         for(int i = 1; i <= n; i++)
//             for(int j = 1; j <= 2; j++)
//                 if(i >= j) dp[i] += dp[i - j];
//
//         return dp[n];
//     }
// }
