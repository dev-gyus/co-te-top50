import java.util.Stack;

public class VaildParentheses {
    public static void main(String[] args){
        String exp = "()[]{}";
//        String exp = "()[]{}(";
//        String exp = "([)]";
        System.out.println(isValid(exp));
    }
    public static boolean isValid(String s){
        //1
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        //2
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
