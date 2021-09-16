class Solution {
    // Method 1: divide into 2 sub problem (using 2 subfuctions) with Greedy Algorithm
    // use DP to find the best combination
    // Too hard & time consuming...
    // Check http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-321-create-maximum-number/

    // Method 2: mono stack
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int n = nums1.length;
        int m = nums2.length;
        int end = Math.min(k, n);
        // enumerate all the possible ways to construct an array with len k from two arrays
        // the length of the res is k
        // we assume that we pick k1 numbers from nums1, therefore we pick (k - k1) numbers
        // from nums2. The possible range of k1 is from Math.max(0, k-len2)
        // to Math.min(len1, k);

        for(int i = Math.max(0, k - m); i <= end; i++){
            int [] n1 = getStack(nums1, i, n);
            int [] n2 = getStack(nums2, k - i, m);
            int [] cur = merge(n1, n2, k);
            if(compare(ans, cur, 0, 0)) ans = cur;
        }

        return ans;
    }

    private boolean compare(int[] ans, int[] cur, int i, int j) {
        int n = ans.length, m = cur.length;
        while(i < n && j < m) {
            if(ans[i] < cur[j]) return true;
            else if(ans[i] > cur[j]) return false;
            i++;
            j++;
        }
        return n - i < m - j;
    }

    private int[] merge(int[] n1, int[] n2, int k) {
        int[] res = new int[k];
        int ind = 0;
        int n = n1.length, i = 0;
        int m = n2.length, j = 0;
        while(i < n && j < m) {
            if(compare(n1, n2, i, j)) res[ind++] = n2[j++];
            else res[ind++] = n1[i++];
        }
        while(i < n) res[ind++] = n1[i++];
        while(j < m) res[ind++] = n2[j++];
        return res;
    }

    private int[] getStack(int[] nums, int k, int n) {
        int ind = 0;
        int[] res = new int[k];
        for(int i = 0; i < n; i++) {
            while(ind != 0 && nums[i] > res[ind - 1] && n - i > k - ind) {
                ind--;
            }
            if(ind < k)
                res[ind++] = nums[i];
        }
        return res;
    }
}
