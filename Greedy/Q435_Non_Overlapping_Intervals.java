class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int non_overlap = 1;
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(end <= intervals[i][0]){
                non_overlap++;
                end = intervals[i][1];
            }
        }

        return intervals.length - non_overlap;
    }
}
