class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        List <Tuple> trees = new ArrayList<>();
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(0).size(); j++){
                if(forest.get(i).get(j) > 1){
                    Tuple <Integer, Integer, Integer> a = new Tuple<>(j, i, forest.get(i).get(j));
                    trees.add(a);
                }
            }
        }


        Collections.sort(trees);

        // starting point
        int sx = 0;
        int sy = 0;

        int total_steps = 0;

        for(int i = 0; i < trees.size(); i++){
            int tx = (int) trees.get(i).x;
            int ty = (int) trees.get(i).y;
            // System.out.println("x: " + tx + " y: " + ty + " height: " + (int) trees.get(i).z);
            int steps = BFS(forest, sx, sy, tx, ty);
            if(steps == Integer.MAX_VALUE) return -1;

            List<Integer> new_l = forest.get(ty);
            new_l.set(tx, 1);
            forest.set(ty, new_l);

            // System.out.println("The steps:" + steps);
            total_steps += steps;

            // update steps
            sx = tx;
            sy = ty;
        }

        return total_steps;
    }

    public int BFS(List<List<Integer>> forest, int startx, int starty, int targetx, int targety){
        int dirs[][] = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int visited[][] = new int[forest.size()][forest.get(0).size()];

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(startx,starty,1));
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            // System.out.println("Size:" + size + " and targetx" + targetx + " and ty: " + targety + "and step" + steps);
            while(size-- > 0){
                Tuple node = q.remove();
                int cx = (int) node.x;
                int cy = (int) node.y;

                // System.out.println("new c" + cx + " cy" + cy);
                // System.out.println(cx == targetx && cy == targety);
                // System.out.println();

                if(cx == targetx && cy == targety) return steps;

                for(int i = 0; i < 4; i++){
                    int x = cx + dirs[i][0];
                    int y = cy + dirs[i][1];

                    // System.out.println("new x" + x + " and new y: " + y);
                    if(x < 0 || x == forest.get(0).size() || y < 0 || y == forest.size() || forest.get(y).get(x) == 0 || visited[y][x] == 1) continue;

                    visited[y][x] = 1;
                    // System.out.println("gd new x" + x + " and new y: " + y);
                    q.add(new Tuple(x, y, 1));
                }
            }
            steps++;
        }
        return Integer.MAX_VALUE;
    }

    public class Tuple <X, Y, Integer> implements Comparable{
        public final X x;
        public final Y y;
        // height
        public final Integer z;

        public Tuple(X x, Y y, Integer z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int compareTo(Object object){
            Tuple t = (Tuple) object;
            return (int) this.z - (int) t.z;
        }
    }


}
