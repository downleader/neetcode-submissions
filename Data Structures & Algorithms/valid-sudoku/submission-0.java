class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] cells = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (rows[i] == null) {
                    rows[i] = new HashSet<>();
                }
                if (!rows[i].add(c)) {
                    return false;
                }

                if (cols[j] == null) {
                    cols[j] = new HashSet<>();
                }
                if (!cols[j].add(c)) {
                    return false;
                }

                int k = 3 * (i / 3) + j / 3;
                if (cells[k] == null) {
                    cells[k] = new HashSet<>();
                }
                if (!cells[k].add(c)) {
                    return false;
                }
            }
        }

        return true;
    }
}
