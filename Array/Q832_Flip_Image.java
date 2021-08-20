class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // try with inplace method?
        int len = image[0].length;
        for (int [] row : image){
            for(int i = 0; i < (row.length + 1) / 2; i++){
                // we can use xor gate to achieve invert
                int tmp = row[i] ^ 1;
                row[i] = row[len - i - 1] ^ 1;
                row[len - i - 1] = tmp;
            }
        }

        return image;
    }
}
