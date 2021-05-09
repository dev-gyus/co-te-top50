import java.util.*;

public class RemoveInvalidParentheses {
    /**
     * BFS
     */
    public static void main(String[] args){
        String s = "(a)())()";
        System.out.println(removeInvalidParentheses(s));
    }

    public static List<String> removeInvalidParentheses(String s){
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        //2
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                String poll = queue.poll();
                if(isValid(poll)){
                    res.add(poll);
                    found = true;
                }
                if(found) continue;

                // index 0 ~ 7 , 하나 삭제하고 6자리 인것만 봄
                for(int j=0; j < poll.length(); j++){
                    //1
                    if(poll.charAt(j) != '(' && poll.charAt(j) != ')') continue;
                    //2
                    String newStr = poll.substring(0,j) + poll.substring(j+1);
                    if(!visited.contains(newStr)){
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return res;
    }
    public static boolean isValid(String s){
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '('){
                count++;
            }else if(c == ')'){
                count--;
                // ())( <- 걸러내야함
                if(count < 0) return false;
            }
        }
        return count == 0;
    }
}
