class Solution {
    public boolean checkRecord(String s) {
        int count = 0;
        char[] c = s.toCharArray();
        int n = s.length();

        for(int i =0; i<n; i++)
        {
            if(c[i] == 'A')
            {
                count++;
                if(count>1)
                    return false;
            }
            if(i<n-2 && c[i]=='L')
            {
                if(c[i+1] == 'L' && c[i+2] =='L')
                    return false;
            }
        }
        return true;
    }
}
