import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] nums = {1,2,3,2,5,2,6,10,4,12};
        System.out.println("value " + solve(nums));
    }

    public static int solve(int[] nums){
        if(nums == null || nums.length == 0) return 0;

        //1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // dp배열의 모든 인덱스에 val값이 세팅됨
        int result = 1;

        //2
        for(int i=0; i < nums.length; i++){
            for(int j=0; j < i; j++){

                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
