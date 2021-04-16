class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> finMat = new ArrayList<Integer>();

        //print in [a, b) way.
        // terminate condition: when left bound >= right;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, top = 0;
        int right = n - 1, bottom = m - 1;
        int i = 0, j = 0;
        int count = 0;

        while(left <= right && top <= bottom){

            for(i = left; i <= right; i++){
                //System.out.println("Top: " + matrix[top][i]);
                finMat.add(matrix[top][i]);
            }
            top++;

            for(j = top; j <= bottom; j++){
                //System.out.println("Right: " +matrix[j][right]);
                finMat.add(matrix[j][right]);
            }

            right--;
            if(top <= bottom){
                for(i = right; i >= left; i--){
                    //System.out.println("Bottom: " + matrix[bottom][i]);
                    finMat.add(matrix[bottom][i]);
                }
            }


            bottom--;

            if(left <= right){
                for(j = bottom ; j >= top; j--){
                    //System.out.println("Left: " + matrix[j][left]);
                    finMat.add(matrix[j][left]);
                }
            }
            left++;

        }

        return finMat;
    }
}
