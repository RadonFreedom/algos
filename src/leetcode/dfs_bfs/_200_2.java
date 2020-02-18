package leetcode.dfs_bfs;

import java.util.LinkedList;

/**
 * @author Shaman
 * @date 2020/2/18 00:28
 */

public class _200_2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        LinkedList<Coor> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    queue.addLast(new Coor(i, j));
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        Coor coor = queue.poll();
                        int x = coor.i;
                        int y = coor.j;
                        if (x + 1 < m && grid[x + 1][y] == '1') {
                            queue.addLast(new Coor(x + 1, y));
                            grid[x + 1][y] = '0';
                        }
                        if (x >= 1 && grid[x - 1][y] == '1') {
                            queue.addLast(new Coor(x - 1, y));
                            grid[x - 1][y] = '0';
                        }
                        if (y + 1 < n && grid[x][y + 1] == '1') {
                            queue.addLast(new Coor(x, y + 1));
                            grid[x][y + 1] = '0';
                        }
                        if (y >= 1 && grid[x][y - 1] == '1') {
                            queue.addLast(new Coor(x, y - 1));
                            grid[x][y - 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }

    private static class Coor {
        int i;
        int j;

        public Coor(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
