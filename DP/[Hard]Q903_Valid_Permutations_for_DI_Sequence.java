// backtracking timeout for java ????

class Solution {
    List<Integer> list = new ArrayList<>();

    public int numPermsDISequence(String s) {
        int n = s.length() + 1;
        boolean [] used = new boolean[n];
        Arrays.fill(used, false);
        int ans = 0;
        for(int i = 0; i < n; i++){
            list.add(i);
            used[i] = true;
            ans += traversal(n, s, 0, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
        return ans;
    }


    public int traversal(int n, String s, int start, boolean[] used){
        // we reached the end of the string
        if(start == n - 1) {
            // System.out.println(list);
            return 1;
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            // System.out.println("i: " + i + " list: " + list + " and order: " + s.charAt(start));
            if(i >= list.get(start) && s.charAt(start) == 'D'){
                // System.out.println("No match for D");
                continue;
            }
            else if(i <= list.get(start) && s.charAt(start) == 'I') {
                // System.out.println("No match for I");
                continue;
            }
            // workable && unused num
            if(used[i] == false){
                list.add(i);
                used[i] = true;
                count += traversal(n, s, start + 1, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }

        return count;
    }
}
