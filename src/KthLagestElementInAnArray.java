import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLagestElementInAnArray {
    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println("array = " + solve_array(nums, k));
        System.out.println("pq = " + solve_pq(nums, k));
    }

    public static int solve_array(int[] nums, int k){
        if(nums.length == 0 || nums == null || k == 0) return 0;
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length - k];
    }

    public static int solve_pq(int[] nums, int k){
        if(nums.length == 0 || nums == null || k == 0) return 0;
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> {return a - b;});
        for (Integer integer : nums) {
            pq.offer(integer);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
