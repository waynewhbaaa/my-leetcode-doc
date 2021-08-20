class Solution {
    private int m, n;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;

        // 1 means already found
        int [][] marked = new int[grid.length][grid[0].length];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && marked[i][j] == 0){
                    // try to reach and find the other land?
                    count++;
                    searchIsland(grid, i, j, marked);
                }
                else continue;
            }
        }

        return count;
    }

    // dfs approch
    public void searchIsland(char[][]grid, int i, int j, int [][]marked){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || marked[i][j] == 1)
            return;

        marked[i][j] = 1;
        // recursion dfs
        searchIsland(grid, i+1, j, marked);
        searchIsland(grid, i, j+1, marked);
        searchIsland(grid, i-1, j, marked);
        searchIsland(grid, i, j-1, marked);
    }
}
