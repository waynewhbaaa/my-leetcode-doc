class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int []> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int [] prev = result.get(result.size() - 1);
            if(prev[1] >= intervals[i][0]){
                prev[1] = Math.max(prev[1], intervals[i][1]);
                result.set(result.size() - 1, prev);
            }
            else{
                result.add(intervals[i]);
            }
        }
        int [][] arr = new int[result.size()][2];
        result.toArray(arr);
        return arr;
    }
}
