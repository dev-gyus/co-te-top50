import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args){
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(points(strs));
    }

    public static int points(String[] strs){
        //1
        Stack<Integer> stack = new Stack<>();

        //2
        for (String str : strs) {
            switch (str){
                case "C" :
                    stack.pop();
                    break;
                case "D" :
                    stack.push(stack.peek() * 2);
                    break;
                case "+" :
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    stack.push(pop2);
                    stack.push(pop1);
                    stack.push(pop1 + pop2);
                    break;
                default :
                    stack.push(Integer.parseInt(str));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
