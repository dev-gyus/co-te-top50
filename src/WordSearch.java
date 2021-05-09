public class WordSearch {
    /**
     * DFS 문제, 응용 많음, 잘나옴
     */
    public static void main(String[] args){
        char[][] grid = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        String word = "ABCCED";
        System.out.println(solve(grid, word));
    }

    static int[][] dirs = {
            {-1,0}, {1,0}, {0,-1}, {0, 1}
    };
    public static boolean solve(char[][] grid, String word){
        //1
        if(grid == null || grid.length == 0 || grid[0].length == 0) return false;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        //2 for or while
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(dfs(grid, visited, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int start, String word){
        if(start == word.length()) return true;
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        if(visited[i][j]) return false;
        if(grid[i][j] != word.charAt(start)) return false; // 핵심

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int dx = i + dir[0];
            int dy = j + dir[1];
            if(dfs(grid, visited, dx, dy, start+1, word)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

}
