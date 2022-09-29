import java.util.*;

public class MaxAreaOfIsland {

    static int maxAreaOfIsland(int[][] grid) {
        int areaMax = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == 1) {
                    areaMax = Math.max(areaMax, areaOfIsland(grid, m, n));
                }
            }
        }
        return areaMax;
    }

    private static int areaOfIsland(int[][] grid, int m, int n) {
        if (m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == 1) {
            grid[m][n] = 0;
            return 1 + areaOfIsland(grid, m + 1, n) + areaOfIsland(grid, m - 1, n) + areaOfIsland(grid, m, n + 1)
                    + areaOfIsland(grid, m, n - 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _grid_rows = 0;
        int _grid_cols = 0;
        _grid_rows = Integer.parseInt(in.nextLine().trim());
        _grid_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _grid = new int[_grid_rows][_grid_cols];
        for (int _grid_i = 0; _grid_i < _grid_rows; _grid_i++) {
            for (int _grid_j = 0; _grid_j < _grid_cols; _grid_j++) {
                _grid[_grid_i][_grid_j] = in.nextInt();

            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        res = maxAreaOfIsland(_grid);
        System.out.println(String.valueOf(res));
        in.close();
    }
}
