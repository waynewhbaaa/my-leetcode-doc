class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        if(ratings.length == 1) return 1;

        int[] candyCount = new int[ratings.length];
        Arrays.fill(candyCount, 1);

        // consider the left neighbors
        for(int i = 0; i < ratings.length; i++){
            if(i > 0 && ratings[i] > ratings[i-1]) candyCount[i] = candyCount[i-1] + 1;
        }

        // consider the right neighbors
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                    candyCount[i] = Math.max(candyCount[i], candyCount[i+1] + 1);
        }

        for(int i = 0; i < candyCount.length; i++){
            sum += candyCount[i];
        }
        return sum;
    }
}
