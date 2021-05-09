import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};

//        for (int i = 0; i < nums.length; i++) {
//            index = 0;
//            for (int j = i+1; j < nums.length; j++){
//                int currentNum = nums[i];
//                if(currentNum < nums[j]){
//                    index = j - i;
//                    break;
//                }
//            }
//            System.out.println(index);
//        }
        DailyTemperature a = new DailyTemperature();
        int[] solve = a.solve(nums);
        for (int i : solve) {
            System.out.println("i = " + i);
        }
    }
    public int[] solve(int[] nums){
        //1 ds
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        //2 for OR while
        for(int i=0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
