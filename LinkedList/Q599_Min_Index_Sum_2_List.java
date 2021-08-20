class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> l1 = new HashMap<>();
        ArrayList <String> ans = new ArrayList<>();
        ArrayList <String> ans1 = new ArrayList<>();
        // O(n)
        for(int i = 0; i < list1.length; i++) l1.put(list1[i], i);
        int min = Integer.MAX_VALUE;

        for(int j = 0; j < list2.length; j++) {
            if(l1.containsKey(list2[j])) {
                int sum = l1.get(list2[j]) + j;
                l1.put(list2[j], sum);
                if(min >= sum) min = sum;
                ans.add(list2[j]);
            }
        }

        for(String s: ans){
            if(l1.containsKey(s) && l1.get(s) == min) ans1.add(s);
        }


        return ans1.toArray(new String[0]);
    }
}
