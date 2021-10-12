class Solution {
    static final int MAXSCORE = 6;

    public int findMinStep(String board, String hand) {
        Map<String, Integer> scoreMap = new HashMap<>();
        String status = board + "," + hand;
        if (backtrack(status, scoreMap) == MAXSCORE) return -1;
        return scoreMap.get(status);
    }

    private int backtrack(String status, Map<String, Integer> scoreMap) {
        if (status.charAt(status.length() - 1) == ',') return MAXSCORE;
        if (scoreMap.containsKey(status)) return scoreMap.get(status);

        String[] game = status.split(",");
        StringBuilder board = new StringBuilder(game[0]);
        StringBuilder hand = new StringBuilder(game[1]);
        int boardLen = board.length();
        int handLen = hand.length();

        int score = MAXSCORE;
        for (int i = 0; i < handLen; i++) {
            for (int j = 0; j <= boardLen; j++) {
                board.insert(j, game[1].charAt(i));
                String newBoard = updateBoard(board.toString());
                if (newBoard.length() == 0) {
                    scoreMap.put(status, 1);
                    return 1;
                }
                hand.deleteCharAt(i);
                score = Math.min(score, backtrack(newBoard + "," + hand.toString(), scoreMap) + 1);
                board.deleteCharAt(j);
                hand.insert(i, game[1].charAt(i));
            }
        }
        scoreMap.put(status, score);
        return score;
    }

    private String updateBoard(String board) {
        int n = board.length();
        for (int i = 0, j = 0; j <= n; j++) {
            if (j < n && board.charAt(j) == board.charAt(i)) continue;
            if (j - i >= 3) return updateBoard(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }
}
