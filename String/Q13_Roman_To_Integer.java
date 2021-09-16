class Solution {
    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int result = 0;
        for(int i=0;i<c.length;i++){
            if(c[i] == 'I'){
                result = result + 1;
            }
            else if(c[i] == 'V'){
                result = result + 5;
                if(i > 0 && c[i-1] == 'I'){
                    result = result - 2;
                }
            }
            else if(c[i] == 'X'){
                result = result + 10;
                if(i > 0 && c[i-1] == 'I'){
                    result = result - 2;
                }
            }
            else if(c[i] == 'L'){
                result = result + 50;
                if(i > 0 && c[i-1] == 'X'){
                    result = result - 20;
                }
            }
            else if(c[i] == 'C'){
                result = result + 100;
                if(i > 0 && c[i-1] == 'X'){
                    result = result - 20;
                }
            }
            else if(c[i] == 'D'){
                result = result + 500;
                if(i > 0 && c[i-1] == 'C'){
                    result = result - 200;
                }
            }
            else if(c[i] == 'M'){
                result = result + 1000;
                if(i > 0 && c[i-1] == 'C'){
                    result = result - 200;
                }
            }
        }
        return result;
    }
}
