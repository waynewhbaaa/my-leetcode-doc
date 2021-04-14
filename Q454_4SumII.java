class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // A B C D will have the same length
        HashMap <Integer, Integer> index = new HashMap<>();
        for(int a: A){
            for(int b: B){
                if(index.containsKey(a+b)){
                    // update key
                    int temp = index.get(a+b) + 1;
                    index.put(a+b, temp);
                }
                else{
                    index.put(a+b, 1);
                }
            }
        }

        int count = 0;
        for(int c: C){
            for(int d: D){
                if(index.containsKey(0 - c - d)){
                    count += index.get(0 - c - d);
                }
            }
        }


        return count;
    }
}
