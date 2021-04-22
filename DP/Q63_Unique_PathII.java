class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][] paths = new int[m][n];

        for(int i = m - 1; i >= 0 && obstacleGrid[i][n-1] == 0; i--){
            paths[i][n-1] = 1;
        }

        for(int j = n - 1; j >= 0 && obstacleGrid[m-1][j] == 0; j--){
            paths[m-1][j] = 1;
         }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                paths[i][j] = (paths[i+1][j] + paths[i][j+1]);
            }
        }

        return paths[0][0];
    }
}
