class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // you will use Queue ...
        List <int[]> que = new LinkedList<>();

        // sort by h and insert on k condition
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0] ? -o1[0]+o2[0] : o1[1]-o2[1];
            }
        });

        for(int i = 0; i < people.length; i++){
            int position = people[i][1];
            que.add(position, people[i]);
        }

        return que.toArray(new int[people.length][]);
    }
}
