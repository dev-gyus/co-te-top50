import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        int[] nums = {2, 8, 11, 14};
        int target = 16;
        int[] result = a.solve(nums, target);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }

    public int[] solve(int[] nums, int target) {
        //1 DataStructure
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        //2 for
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]);
                result[0] = value + 1;
                result[1] = i + 1;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
}
