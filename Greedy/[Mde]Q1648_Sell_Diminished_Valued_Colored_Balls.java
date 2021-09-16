import java.math.BigInteger;
class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Integer[] what = Arrays.stream(inventory).boxed().toArray(Integer[]::new );
        Arrays.sort(what, Collections.reverseOrder());
        for(int i = 0; i < what.length; i++){
            inventory[i] = what[i];
        }
        int cur = inventory[0];
        int j = 0;
        int n = inventory.length;
        long ans = 0L;
        // greedy approach + math
        while(orders > 0){
            while(j < n && inventory[j] == cur) j++;
            int next = j == n ? 0 : inventory[j];
            int count = Math.min(orders, j * (cur - next));
            int t = cur - next;
            int r = 0;
            if(orders < j * (cur - next)) {
                t = orders / j;
                r = orders % j;
            }
            ans += (long) (cur * 2 - t + 1) * t / 2 * j;
            ans += (long) (cur - t) * r;
            ans %= 1000000007;

            orders -= count;
            cur = next;
        }

        return (int) ans;
    }
}
