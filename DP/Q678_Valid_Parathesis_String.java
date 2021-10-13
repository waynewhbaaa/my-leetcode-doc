class Solution {
    public boolean checkValidString(String s) {
        // Method 1: DP O(n^3)
//         int n = s.length();
//         boolean [][] dp = new boolean[n][n];
//         for (int i = 0; i < n; i++) {
//             if (s.charAt(i) == '*') dp[i][i] = true;
//             if (i < n-1 &&
//                     (s.charAt(i) == '(' || s.charAt(i) == '*') &&
//                     (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
//                 dp[i][i+1] = true;
//             }
//         }

//         for (int size = 2; size < n; size++) {
//             for (int i = 0; i + size < n; i++) {
//                 if (s.charAt(i) == '*' && dp[i+1][i+size] == true) {
//                     dp[i][i+size] = true;
//                 } else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
//                     for (int k = i+1; k <= i+size; k++) {
//                         if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
//                                 (k == i+1 || dp[i+1][k-1]) &&
//                                 (k == i+size || dp[k+1][i+size])) {
//                             dp[i][i+size] = true;
//                         }
//                     }
//                 }
//             }
//         }

//         return dp[0][n-1];

        // Method 2: counting (greedy)

        int lo = 0, hi = 0;
        for(char c: s.toCharArray()){
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;

            if(hi < 0) break;
            lo = Math.max(lo, 0);
        }

        return lo == 0;
    }
}
