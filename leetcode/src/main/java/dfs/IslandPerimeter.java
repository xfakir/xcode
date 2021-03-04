package dfs;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return area(grid,i,j);
                }
            }
        }
        return 0;
    }

    private int area(int[][] grid,int r,int c) {
        if (!inArea(grid,r,c)) {
            return 1;
        }

        if (grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 2;

        return area(grid,r-1,c) + area(grid,r,c-1) +area(grid,r+1,c) + area(grid,r,c+1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length;
    }
}
