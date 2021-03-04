package dfs;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result,area(grid,i,j));
            }
        }
        return result;
    }

    private int area(int[][] grid,int r,int c) {
        if (!inArea(grid,r,c)) {
            return 0;
        }

        if (grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 2;

        return 1 + area(grid,r-1,c) + area(grid,r,c-1) +area(grid,r+1,c) + area(grid,r,c+1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length;
    }
}
