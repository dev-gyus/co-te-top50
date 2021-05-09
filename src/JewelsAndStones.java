import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args){
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(solve(jewels, stones));
    }
    public static int solve(String jewels, String stones){
        //1. ds
        Set<Character> set = new HashSet<>();
        for(char jewel : jewels.toCharArray()){
            set.add(jewel); // a, A set에 입력됨 만약 중복되는 문자가 있으면 하나만 저장 (set = 중복을 허용하지 않음)
        }
        int result = 0;

        //2. for
        for(char stone : stones.toCharArray()){
            if(set.contains(stone)) result++;
        }

        return result;
    }
}
