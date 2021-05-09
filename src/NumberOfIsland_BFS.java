import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_BFS {
    /**
     * BFS -> 바베큐 -> Queue사용
     * DFS -> 스택
     */
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

    public static int solve(char[][] grid){
        //1 ds & error managing
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;

        //2 (0,0)위치가 1인 것 부터 찾는다
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    static int[][] dirs = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    public static void bfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0'; // 이미 1인 것을 판단했을때는 더이상 탐색 할 필요가 없기때문에 바꿔줌
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] point = queue.poll();
            for(int k=0; k < size; k++){
                for(int[] dir : dirs){
                    int x1 = point[0] + dir[0];
                    int y1 = point[1] + dir[1];
                    if(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == '1'){
                        grid[x1][y1] = '0';
                        queue.offer(new int[] {x1,y1});
                        System.out.println("x1 = " + x1 + ", y1 = " + y1);
                    }
                }
            }
        }
        for (char[] chars : grid) {
            System.out.println(chars);
        }
    }

}
