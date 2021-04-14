class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] index = new int[26];

        for(int i = 0; i < magazine.length(); i++){
            int a = magazine.charAt(i) - 'a';
            index[a]++;
        }

        //check ransomNote
        for(int j = 0; j < ransomNote.length(); j++){
            int b = ransomNote.charAt(j) - 'a';
            index[b]--;

            if(index[b] < 0){
                return false;
            }
        }
        return true;
    }
}
