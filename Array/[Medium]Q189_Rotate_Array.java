class Solution {
    // method 1: swap and reverse...
//     public void rotate(int[] nums, int k) {
//         if(nums == null || nums.length < 2){
//             return;
//         }

//         k = k % nums.length;
//         swap(nums, 0, nums.length - k - 1);
//         swap(nums, nums.length - k, nums.length - 1);
//         swap(nums, 0, nums.length - 1);
//     }

//     public void swap(int [] nums, int i, int j){
//         if(i > j) return;

//         int temp = 0;

//         while(i <= j){
//             temp = nums[i];
//             nums[i] = nums[j];
//             nums[j] = temp;
//             i++;
//             j--;
//         }
//     }

    // method 2: gcd approach (similar to left rotation)

    public void rotate(int [] nums, int k){
        int n = nums.length;
        // use as left rotation...
        while(k > n) k -= n;

        k = n - k;
        k = k % n;

        int i, j , m, temp;

        int g_c_d = gcd(n, k);

        for(i = 0; i < g_c_d; i++){
            temp = nums[i];
            j = i;
            while(true){
                m = j + k;
                if(m >= n) m -= n;
                if(m == i) break;

                nums[j] = nums[m];
                j = m;
            }
            nums[j] = temp;
        }
    }

    // Function to get gcd of a and b
    public int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
