package backtrack;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 */
public class Exist {
    private boolean[][] marked;

    private int[][] direction = {{-1,0},{0,-1},{1,0},{0,1}};

    private int m;
    private int n;

    private char[][] board;
    private String word;

    public boolean solution(char[][] board,String word) {
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        this.board = board;
        this.word = word;
        marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int i,int j,int index) {
        if (index == word.length()-1) {
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] == word.charAt(index)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX,newY) && !marked[newX][newY])
                    if (backtrack(newX,newY,index+1)) {
                        return true;
                    }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
