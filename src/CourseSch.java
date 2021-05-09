import java.util.LinkedList;
import java.util.Queue;

public class CourseSch {
    /**
     * 위상정렬(TopologicalSort) -> BFS/DFS
     * 위상정렬 파악하는 힌트 = 어떤걸 하기 위해선 전제 조건이 있는경우
     */
    public static void main(String[] args){
        int course = 4;
        int[][] nums = {
                {1,0},
                {2,1},
                {3,2}
        };
        int[][] nums2 = {
                {1,0},
                {0,1}
        };
        System.out.println(solve(course, nums2));
    }

    public static boolean solve(int courseNumber, int[][] nums){
        if(courseNumber <= 0) return false;

        //1. inDegree배열, Queue
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        //1-1. inDegree
        int numsLength = nums.length;
        for(int i=0; i < numsLength; i++){
            inDegree[nums[i][1]]++;
        }

        //1-2. 큐에 넣는다, 3을 찾는다
        int inDegreeLength = inDegree.length;
        for(int i=0; i < inDegreeLength; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int firstZeroVal = queue.poll();

            for(int i=0; i < numsLength; i++){
                if(firstZeroVal == nums[i][0]){
                    inDegree[nums[i][1]]--;
                    if(inDegree[nums[i][1]] == 0) queue.offer(nums[i][1]);
                }
            }
        }

        //4
        for(int i=0; i < inDegreeLength; i++){
            if(inDegree[i] != 0) return false;
        }
        return true;
    }

}
