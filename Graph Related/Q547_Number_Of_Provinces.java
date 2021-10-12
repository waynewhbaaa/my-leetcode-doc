class Solution {
    public int findCircleNum(int[][] isConnected) {
        // union find lol
        UF uf = new UF(isConnected.length);

        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.size();
    }

    class UF {
        private int[] parent;
        private byte[] rank;
        private int size;

        public UF(int n) {
            if (n < 0) throw new IllegalArgumentException();
            parent = new int[n];
            rank = new byte[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            size = n;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pr = find(p);
            int qr = find(q);
            if (pr == qr) return;
            if (rank[pr] < rank[qr]) {
                parent[pr] = qr;
            } else {
                parent[qr] = pr;
                if (rank[pr] == rank[qr]) rank[pr]++;
            }
            size--;
        }

        public int size() {
            return size;
        }
    }
}
