class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int index = digits.length - 1;
        do{
            digits[index--]++;
            // there is an carry bit
            if(digits[index + 1] == 10){
                digits[index + 1] = 0;
                if(index == -1) {
                    // create a new array
                    int [] new_digits = new int[digits.length + 1];
                    new_digits[0] = 1;
                    for(int i = 0; i < digits.length; i++){
                        new_digits[i+1] = digits[i];
                    }
                    digits = new_digits;
                    System.out.println(digits);
                    break;
                }
                carry = 1;
            }
            else {
                carry = 0;
            }
        }while(carry != 0);
        return digits;
    }
}
