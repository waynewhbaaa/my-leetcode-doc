import java.util.stream.*;
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        if(Math.max(l1, l2) * 1 > Math.min(l1, l2) * 6) return -1;

        int s1 = IntStream.of(nums1).sum();
        int s2 = IntStream.of(nums2).sum();

        if(s1 > s2) return minOperations(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        nums2 = mirror(nums2);

        int ans = 0;
        int i = 0, j = 0;

        while(s1 < s2){
            int d1 = i == l1 ? 0 : 6 - nums1[i];
            int d2 = j == l2 ? 0 : nums2[j] - 1;
            if(d1 >= d2){
                s1 += d1;
                i++;
            }
            else{
                s2 -= d2;
                j++;
            }
            ans++;
        }

        return ans;
    }

    public int[] mirror(int[] arr){
        for( int i = 0; i < arr.length/2; ++i )
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        return arr;
    }
}
