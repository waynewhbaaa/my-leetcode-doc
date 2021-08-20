class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1 || num == 4) return true;

        int start = 1;
        int end = Math.min(num / 2, 46345), mid = 0;


        while(start <= end){
            mid = (start + end) / 2;
            if(mid == num / mid && num % mid == 0) return true;
            else if(mid > num / mid) end = mid - 1;
            else start = mid + 1;
        }

        return false;
    }
}
