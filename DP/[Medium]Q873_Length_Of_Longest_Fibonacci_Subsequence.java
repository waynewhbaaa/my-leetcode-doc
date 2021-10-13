class Solution {
    public int lenLongestFibSubseq(int[] a) {
        int n=a.length;
        int size=a[n-1]+1;
        int[][]dp=new int[n][n];
        HashMap<Integer, Integer> ind=new HashMap<>();
        int ans=0;
        for(int i=0; i<n; i++)
        {
            ind.put(a[i], i);
            Arrays.fill(dp[i], 2);
        }
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int sum=a[i]+a[j];
                if(sum>=size)
                {
                    break;
                }

                if(ind.containsKey(sum)){
                    int k=ind.get(sum);
                    dp[j][k]=dp[i][j]+1;
                    ans=Math.max(ans, dp[j][k]);
                }

            }
        }
        return ans > 2 ? ans:0;
    }
}
