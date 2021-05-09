import java.util.ArrayList;
import java.util.List;

public class Permutation {
    /**
     * Permutation(퍼뜨리다, 순열) 에서 유명한 문제
     * DFS로 해결
     */
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(permute_dfs(nums));
    }

    public static List<List<Integer>> permute_dfs(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        dfs(nums, result, list);

        return result;
    }
    public static void dfs(int[] nums, List<List<Integer>> result, List<Integer> cur){
        //1 담는거
        if(cur.size() == nums.length){
            List<Integer> list = new ArrayList<>(cur);
            result.add(list);
        }

        //2 for로 저장, 탈출
        for(int i = 0; i < nums.length; i++){

//            if(cur.size() == nums.length){
//                continue;
//            }
            if(cur.contains(nums[i])) continue; // 문제 조건에서 이미 cur에 들어온 수는 필요없음
            cur.add(nums[i]);
            dfs(nums, result, cur);
            cur.remove(cur.size()-1);
        }
    }
}
