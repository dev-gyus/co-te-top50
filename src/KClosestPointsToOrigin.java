import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin a = new KClosestPointsToOrigin();
        int[][] points = {
                {1, 3},
                {-2, 2}
        };
        a.print(points);
        int k = 1;
        int[][] result = a.solve(points, k);
        System.out.println("======result=======");
        a.print(result);
    }
    public int[][] solve(int[][] points, int k){
        //1. ds
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        });
        int[][] result = new int[k][2];

        //2. for or while
        for(int[] point : points){
            pq.offer(point);
        }
        int index = 0;
        while(index < k){
            result[index] = pq.poll();
            index++;
        }
        return result;
    }
    public void print(int[][] target){
        for (int[] ints : target) {
            System.out.println("{" + ints[0] + ", " + ints[1] + "}");
        }
    }
}
