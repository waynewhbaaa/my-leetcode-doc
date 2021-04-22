class Solution {
    public int uniquePaths(int m, int n) {
        // Method 1: Recursion (works but will get Time limit exceeded error)
        // Time Complexity O(2^(m+n-1));
        // return dfs(1, 1, m, n);


        // Method 2: DP
        int [][] paths = new int[m][n];

        for(int i = m - 1; i >= 0; i--){
            paths[i][n-1] = 1;
        }

        for(int j = n - 1; j >= 0; j--){
            paths[m-1][j] = 1;
         }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                paths[i][j] = paths[i+1][j] + paths[i][j+1];
            }
        }

        return paths[0][0];
    }

//     private int dfs(int row, int column, int m, int n){
//         if(row > m || column > n) return 0;
//         if(row == m && column == n) return 1;

//         return dfs(row+1, column, m, n) + dfs(row, column + 1, m, n);
//     }
}
