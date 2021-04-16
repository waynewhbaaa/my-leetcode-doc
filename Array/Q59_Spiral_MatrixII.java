class Solution {
    public int[][] generateMatrix(int n) {
        int[][] finalMat = new int[n][n];

        int loop = n / 2;

        int count = 0;

        int startx = 0, starty = 0;

        int offset = 1;

        int i= startx, j = starty;

        // fill in
        while(loop-- > 0){
            // top:  left to right
            i = startx;
            j = starty;
            for(; i < startx + n - offset; i++){
                finalMat[j][i] = ++count;
                System.out.println("num: " + count);
            }
            // right:  top to down
            for(; j < starty + n - offset; j++){
                finalMat[j][i] = ++count;
            }

            // bottom: right to left
            for(; i > starty; i--){
                finalMat[j][i] = ++count;
            }
            // left: bottom to up
            for(; j > startx; j--){
                finalMat[j][i] = ++count;
            }

            //update the startx and starty to prevent overlapping
            startx++;
            starty++;

            //update offset since it has been filled from 4 directions.
            offset += 2;
        }

        // handle the inner case. This should only happen when n is odd
        if(n % 2 == 1){
            finalMat[startx][starty] = ++count;
        }

        return finalMat;
    }
}
