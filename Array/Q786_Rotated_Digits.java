class Solution {
    public int rotatedDigits(int n) {
        int [] dp = new int[n+1];

        int count = 0;

        // dp
        // 0 represents the 3, 4, 7,
        // 1 represents 0, 1, 8
        // 2 represents 2, 5, 6, 9

        // test case: n = 35
        // valid 2, 5, 6, 9, 12, 15, 16, 19, 20, 21, 22, 23, 25, 26, 29

        for(int i = 0; i < 10; i++){

        }

        for(int i = 0; i <= n; i++){
            if(i < 10){
                if(i == 1 || i == 8 || i == 0){
                dp[i] = 1;
                }
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
            }
            else{
                int a = dp[i / 10];
                int b = dp[i % 10];

                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                }
            }

        }

        return count;
    }
}
