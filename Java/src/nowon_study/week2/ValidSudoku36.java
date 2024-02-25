package nowon_study.week2;

public class ValidSudoku36 {
    public static void main(String[] args) {
        char[][] a1 = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};
//        System.out.println(ValidSudoku36.isValidSudoku(a1)); // false

        char[][] a2 = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
//        System.out.println(ValidSudoku36.isValidSudoku(a2)); // false

        char[][] a3 = {        {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(ValidSudoku36.isValidSudoku(a3)); // true
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i=0; i<board.length; i++) {
            boolean[] visited = new boolean[10];
            for (int j=0; j<board.length; j++) {
                char word1 = board[j][i];
                if (word1 != '.') {
                    int v1 = Integer.parseInt(String.valueOf(word1));
                    if (!visited[v1]) {
                        visited[v1] = true;
                    } else {
                        return false;
                    }
                }
            }

            boolean[] visited2 = new boolean[10];
            for (int j=0; j<board.length; j++) {
                char word2 = board[i][j];
                if (word2 != '.') {
                    int v2 = Integer.parseInt(String.valueOf(word2));
                    if (!visited2[v2]) {
                        visited2[v2] = true;
                    } else {
                        return false;
                    }
                }
            }

        }

        int[] x = {1, 4, 7};
        int[] y = {1, 4, 7};
        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int i=0; i<x.length; i++) {
            for (int j=0; j<y.length; j++) {
                boolean[] visited = new boolean[10];
                for (int k=0; k<dx.length; k++) {
                    int nx = x[i] + dx[k];
                    int ny = y[j] + dy[k];
                    char word = board[nx][ny];
                    if (word != '.') {
                        if (!visited[Integer.parseInt(String.valueOf(word))]) {
                            visited[Integer.parseInt(String.valueOf(word))] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

