class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        String r = String.join("", Collections.nCopies(n, "."));
        for(int i = 0; i < n; i++){
            board.add(r);
        }
        traversal(n, 0, board);
        return ans;
    }

    public void traversal(int n, int row, List<String> board){
        if(row == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int i = 0; i < n; i++){
            if(check(row, i, board, n)){
                String oldStr = board.get(row);
                String newStr = board.get(row).substring(0, i) + 'Q' + board.get(row).substring(i+1);
                board.set(row, newStr);
                traversal(n, row+1, board);
                board.set(row, oldStr);
            }
        }
    }

    public boolean check(int row, int col, List<String> chessboard, int n){
        int count = 0;
        // 检查列
        for (int i = 0; i < row; i++) { // 这是一个剪枝
            if (chessboard.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查 45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--) {
            if (chessboard.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
