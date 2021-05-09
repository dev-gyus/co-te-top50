import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * Permutation과 비슷하게 풀수있지만 Condition만 다른 문제
     * DFS로 해결
     */
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        dfs(nums, result, list, 0);

        return result;
    }
    public static void dfs(int[] nums, List<List<Integer>> result, List<Integer> cur, int start){
        //1 담는거
        List<Integer> newList = new ArrayList<>(cur);
        result.add(newList);

        //2
        for(int i=start; i<nums.length; i++){
            cur.add(nums[i]);
            dfs(nums, result, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }
}