import java.util.LinkedList;
import java.util.Queue;

public class Maze1_BFS {
    /**
     * Graph -> BFS/DFS
     */
    public static void main(String[] args){
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4};
//        int[] dest = {3,2}; // 3,2는 공이 멈출수 없는 곳이므로 false
        int[] dest = {4,4};
        System.out.println(hasPath(maze, start, dest));
    }

    static int[][] dirs = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    static int m,n;

    public static boolean hasPath(int[][] maze, int[] start, int[] dest){
        m = maze.length;
        n = maze[0].length;
        if(start[0] == dest[0] && start[1] == dest[1]) return true;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1]});

        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x1 = p[0] + dir[0];
                int y1 = p[1] + dir[1];
                while(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && maze[x1][y1] == 0){
                    x1 += dir[0];
                    y1 += dir[1];
                }
                x1 -= dir[0];
                y1 -= dir[1];
                if(visited[x1][y1]) continue;
                visited[x1][y1] = true;
                if(x1 == dest[0] && y1 == dest[1]) return true;
                queue.offer(new int[] {x1,y1});
            }
        }
        return false;
    }

}
