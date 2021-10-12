class Solution {

    HashMap<Integer, Integer> root;
    public int minIncrementForUnique(int[] A) {
        root = new HashMap();
        int res = 0;
        for (int a : A) res += find(a) - a;
        return res;
    }
    int find(int x) {
        if(root.containsKey(x)) root.put(x, find(root.get(x) + 1));
        else root.put(x, x);
        return root.get(x);
    }
}
