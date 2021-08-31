class Solution {
    public String addBinary(String a, String b) {
        int a_len = a.length() - 1, b_len = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(a_len >=0 || b_len >= 0){
            int bit = carry;
            if(a_len >= 0) bit += a.charAt(a_len--) - '0';
            if(b_len >= 0) bit += b.charAt(b_len--) - '0';
            sb.append(bit & 1);
            carry = bit >> 1;
        }

        if(carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
