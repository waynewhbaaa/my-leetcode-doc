class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int ans = 1;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > points[i - 1][1]) ans++;
            else points[i][1] = Math.min(points[i][1], points[i-1][1]);
        }

        return ans;
    }
}
