class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // we only need to rotate a maximum of 3 times;
        for(int i = 0; i < 4; i++){
            if(Arrays.deepEquals(mat, target)) return true;

            rotate(mat);
        }
        return false;
    }

    public void rotate(int[][] mat){
      for (int i = 0, j = mat.length - 1; i < j; ++i, --j) { // reverse rows order.
            int[] tmp = mat[i];
            mat[i] = mat[j];
            mat[j] = tmp;
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = i+1; j < mat[0].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}
