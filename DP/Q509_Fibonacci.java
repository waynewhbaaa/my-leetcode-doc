class Solution {
    public int fib(int n) {
        int [] arr = new int[n];

        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        arr[0] = arr[1] = 1;

        for(int i = 2; i < n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n-1];
    }
}
