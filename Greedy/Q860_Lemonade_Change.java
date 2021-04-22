class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] != 5) return false;
        int fiveCount = 0;
        int tenCount = 0;

        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5) fiveCount++;
            else if(bills[i] == 10) {tenCount++; fiveCount--;}
            else{
                if(tenCount > 0) {
                    tenCount--;
                    fiveCount--;
                }
                else{
                    fiveCount -= 3;
                }
            }

            if(fiveCount < 0 || tenCount < 0) return false;
        }

        return true;
    }
}
