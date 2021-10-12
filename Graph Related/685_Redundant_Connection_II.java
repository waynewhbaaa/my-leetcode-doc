class Solution {
    int [] ancs;
    int [] parents;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        ancs = new int[edges.length+1];
        parents = new int[edges.length+1];

        int [] pair=null;
        int [] pair1=null;

        int [] cycle = null;
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(ancs[u] == 0) ancs[u] = u;
            if(ancs[v] == 0) ancs[v] = v;

            if(parents[v] != 0){
                pair = new int[]{parents[v], v};
                pair1 = edge;
            }

            else{
                parents[v] = u;
                int ancU = find(u);
                int ancV = find(v);

                if(ancU != ancV){
                    ancs[ancV] = ancs[ancU];
                }
                else{
                    // there is a cycle
                    cycle = edge;
                }
            }
        }

        if(pair != null && pair1 != null) return cycle == null ? pair1 : pair;
        else return cycle;

    }

    public int find(int node){
        if(ancs[node] == node) return node;
        ancs[node] = find(ancs[node]);

        return ancs[node];
    }

}
