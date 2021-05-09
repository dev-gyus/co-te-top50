import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    /**
     * 이중 for 문
     */
    public static void main(String[] args){
        System.out.println(solve("23"));
    }

    public static List<String> solve(String digits){
        String digitLetter[] = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        result.add("");
        for(int i=0; i < digits.length(); i++){
            result = combine(result, digitLetter[digits.charAt(i) - '0']);
        }
        return result;
    }
    private static List<String> combine(List<String> result, String digit){
        List<String> newList = new ArrayList<>();

        for(int i=0; i<digit.length(); i++){
            for(String firstStr : result){
                newList.add(firstStr + digit.charAt(i));
            }
        }
        return newList;
    }
}
