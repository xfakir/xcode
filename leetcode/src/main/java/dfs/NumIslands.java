package dfs;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    area(grid,i,j);
                }
            }
        }
        return count;
    }


    private void area(char[][] grid,int r,int c) {
        if (!inArea(grid,r,c)) {
            return ;
        }

        if (grid[r][c] != 1) {
            return ;
        }

        grid[r][c] = 2;

        area(grid,r-1,c);
        area(grid,r,c-1);
        area(grid,r+1,c);
        area(grid,r,c+1);
    }

    private boolean inArea(char[][] grid, int r, int c) {
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length;
    }
}
