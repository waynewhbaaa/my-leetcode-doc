class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // This should be considered as a 2 dimensional backpack
        // because we need to consider m and n at the same time

        int[][] dp = new int[m+1][n+1];
        for(String s : strs){
            int zeroNum = 0, oneNum = 0;
            for(char c: s.toCharArray()){
                if(c == '0') zeroNum++;
                else oneNum++;
            }

            for(int i = m; i >= zeroNum; i--){
                for(int j = n; j >= oneNum; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
