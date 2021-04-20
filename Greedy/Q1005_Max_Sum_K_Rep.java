class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);

        int sum = 0;
        int index = 0;
        while(K > 0){

            A[index] *= -1;
            K--;
            // this will guarantee not to enter the condition when we find the min abs avlue
            if(index + 1 < A.length && A[index] > A[index + 1]) index++;
        }

        for(int num : A){
            sum += num;
        }

        return sum;
    }
}
