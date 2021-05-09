import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args){
        FindAllAnagrams a = new FindAllAnagrams();
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        System.out.println(a.findAnagrams(txt, pat));
    }
    public List<Integer> findAnagrams(String txt, String pat){
        //1
        List<Integer> result = new ArrayList<>();
        if(txt == null || txt.length() == 0 || pat == null || pat.length() == 0 || txt.length() < pat.length()) return result;

        //2
        int[] patArray = new int[256];
        for(int i=0; i < pat.length(); i++){
            patArray[pat.charAt(i)]++;
        }
        for(int i=0; i < txt.length()-pat.length() + 1; i++){
            int[] txtArray = new int[256];
            for(int j=0; j < pat.length(); j++){
                txtArray[txt.charAt(i+j)]++;
            }
            if(check(patArray, txtArray)){
                result.add(i);
            }
        }
        return result;
    }

    public boolean check(int[] patArray, int[] txtArray){
        for(int i=0; i < patArray.length; i++){
            if(patArray[i] != txtArray[i]){
                return false;
            }
        }
        return true;
    }
}
