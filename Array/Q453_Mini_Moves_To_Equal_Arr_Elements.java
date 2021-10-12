class Solution {
    /*
      sumBeforeMoves   - sum of all elements in given array.
      moves            - number of moves required to make all array elements equal.
      newValue         - value of array elements after `moves` moves
      numberOfElements - number of elements in the given array

      As per the requirements, we need to increment `numberOfElements - 1` elements in each move.
      So, after `moves` moves, we add `moves * (numberOfElements - 1)` to the total sum of all elements in given array.
      Hence, equation 1 is as follows:
      `numberOfElements * newValue = sumBeforeMoves + moves * (numberOfElements - 1)`

      min              - Minimum value in the given array.
      On every move, we also update the minimum value from the given array.
      Hence, equation 2 is as follows:
      `newValue = min + moves`

      Substituate `newValue` from equation 2 to equation 1
      numberOfElements * (min + moves) = sumBeforeMoves + moves * (numberOfElements - 1)
      numberOfElements * min + numberOfElements * moves = sumBeforeMoves + moves * numberOfElements - moves : Expand brackets
      numberOfElements * min = sumBeforeMoves - moves : Cancel `numberOfElements * moves` from both sides

      `moves = sumBeforeMoves - numberOfElements * min`
    */

    public int minMoves(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int sum = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }

        return sum - n * min;
    }
}
