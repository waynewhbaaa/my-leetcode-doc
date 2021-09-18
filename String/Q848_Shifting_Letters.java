class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder res = new StringBuilder();
        int n = shifts.length;
        res.append(getShiftVal(shifts[n-1], s.charAt(n-1)));

        for(int i = n - 2; i >= 0; i--){
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;
            char ch = getShiftVal(shifts[i], s.charAt(i));
            res.append(ch);
        }

        return res.reverse().toString();
    }

    public char getShiftVal(int val, char c){
        int new_val = ((int) (c - 'a') + val) % 26;
        return (char) (new_val + 'a');
    }
}
