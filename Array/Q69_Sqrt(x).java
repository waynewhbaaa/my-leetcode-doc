class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;

        int start = 1;
        int end = x / 2;
        int mid = 0;
        while(start <= end){
            mid = (end + start) >> 1;
            // System.out.println(mid);
            // To prevent overflow for int, prevent (mid * mid) but use mid with x / mid;
            if(mid == x / mid) return mid;
            else if(mid > x / mid) end = mid - 1;
            else if(mid < x / mid) start = mid + 1;
        }
        return start - 1;
    }
}
