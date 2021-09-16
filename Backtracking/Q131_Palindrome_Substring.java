class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        traversal(s, 0);
        return ans;
    }

    public void traversal(String s, int start){
        if(start >= s.length()) {
            ans.add(new ArrayList(list));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                String str = s.substring(start, i + 1);
                list.add(str);
            }
            else{
                continue;
            }
            traversal(s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public boolean isPalindrome(String s, int start, int i){
        // System.out.println(s.substring(start, i+1));
        if(start == i) return true;
        int left = start;
        int right = i;

        while(left <= right){

            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }
}
