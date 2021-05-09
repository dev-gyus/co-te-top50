public class NumberOfIsland_DFS {
    public static void main(String[] args){
        char[][] a = {
                {'1','1','1','0','1'},
                {'1','1','1','0','0'},
                {'1','1','0','0','1'},
                {'0','0','0','0','1'},
        };

        int solve = solve(a);
        System.out.println(solve);
    }

    /**
     * 대표적인 DFS문제, 판단기준: 어떤 노드를 기준으로 조건에 해당하는 것들을 전부 탐색함 (1이 나오는 경우를 기준으로 그 주변 4방으로의 모든 노드 탐색)
     * DFS = 재귀호출
     */
    public static int solve(char[][] grid){
        //1 ds & error managing
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;

        //2 (0,0)위치가 1인 것 부터 찾는다
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = 'x'; // 이미 1인 것을 판단했을때는 더이상 탐색 할 필요가 없기때문에 바꿔줌

        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
    }

}
