class Solution {

    // we still need to have something to memorize?
    private byte[] m_;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if(sum < desiredTotal) return false;
        // why do we have this case...
        if(desiredTotal <= 0) return true;

        m_ = new byte[1 << maxChoosableInteger];

        return checkWinner(maxChoosableInteger, desiredTotal, 0);
    }

    // you can think state as a 32 bit binary and each bit represents whether it is used or not
    public boolean checkWinner(int max, int desiredTotal, int state){
        if(desiredTotal <= 0) return false;

        if (m_[state] != 0) return m_[state] == 1;

        for(int i = 0; i < max; ++i){
            if ((state & (1 << i)) > 0) continue; // this number has been used

            // check next player can win or not. If not, current player win
            if (!checkWinner(max, desiredTotal - (i + 1), state | (1 << i))) {
                m_[state] = 1;
                return true;
            }
        }
        m_[state] = -1;
        return false;
    }
}
