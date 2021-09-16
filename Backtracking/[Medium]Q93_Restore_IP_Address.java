class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        if(s.length() < 4) return ans;

        if(s.length() == 4) {
            String str = s.charAt(0) + "." + s.charAt(1) + "." + s.charAt(2) + "." + s.charAt(3);
            ans.add(str);
            return ans;
        }

        traversal(s, 0, 0);
        return ans;
    }

    public void traversal(String s, int start, int pointNum){

        if(pointNum == 3) {

            if(isValid(s, start, s.length() - 1))
                ans.add(s);
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isValid(s, start, i)){

                String str = s.substring(0, i + 1) + "." + s.substring(i + 1);
                //System.out.println(str);
                pointNum++;
                traversal(str, i + 2, pointNum);
                pointNum--;
            }
            else{
                break;
            }
        }
    }
    public boolean isValid(String s, int start, int end){
        if(start > end)
            return false;
        if(s.charAt(start) =='0' && start != end)
            return false;

        int num = 0;
        for(int i = start; i <= end; i++){
            if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;

            num = num * 10 + (s.charAt(i) - '0');
            if(num > 255) return false;
        }

        return true;
    }
}
