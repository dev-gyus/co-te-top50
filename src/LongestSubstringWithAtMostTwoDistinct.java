import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinct {
    public static void main(String[] args){
        String s = "ccaabbb";
        System.out.println(solve(s));
    }
    public static int solve(String s){
        //1
        int start = 0;
        int end = 0;
        int length = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();

        //2
        while(end < s.length()){
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if(map.get(endChar) == 1) count++;
            end++;

            //3 count가 3일경우 맵에 저장된 문자 종류가 3개라는 의미이므로 map에 저장된 문자 종류 2개로 만들어야함
            while(count > 2){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
                if(map.get(startChar) == 0){
                    count--;
                }
            }
            length = Math.max(length, end-start);
        }
        return length;
    }
}
