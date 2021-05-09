import java.util.ArrayList;
import java.util.List;

public class GeneratedParentheses {
    /**
     * Backtracking
     * 왼쪽부터 탐색들어감
     */
    public static void main(String[] args){
        System.out.println(generatedParenthesis_dfs(4));
    }

    public static List<String> generatedParenthesis_dfs(int n){
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n, "");
        return result;
    }
    static int count = 0;
    public static void dfs(List<String> result, String str, int left, int right, String str1) { // str1은 테스트용 참조값
        count++;
        System.out.println("str\t" + str + " left: " + left + " right: " + right + " count: " + count + " str1: " + str1);

        //1
        if(left < 0 || left > right) return; // 왼쪽부터 항상 -를 하기 때문에 left가 클수가 없음

        //2
        if(left==0 && right==0){
            result.add(str);
            return;
        }
        dfs(result, str + '(', left-1, right, str1 + "+"); // 왼쪽부터 줄여가면서 dfs실행 str1은 테스트용 참조값
        dfs(result, str + ')', left, right-1, str1 + "-");

    }

}
