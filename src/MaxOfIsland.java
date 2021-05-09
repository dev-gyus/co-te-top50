public class MaxOfIsland {
    /**
     * DFS 문제? -> NumberOfIsland와 같은 원리 문제
     */
    public static void main(String[] args){
        int[][] grid = {
                {1,1,0,1,1},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,1,0,1,1},
                {1,0,1,1,1},
                {1,0,1,1,1}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid){
        //1
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        //2 for or while
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, 0);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int i, int j, int area) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return area;
        grid[i][j] = 0;
        area++;
        area = dfs(grid, i-1, j, area);
        area = dfs(grid, i+1, j, area);
        area = dfs(grid, i, j-1, area);
        area = dfs(grid, i, j+1, area);

        return area;
    }

}
