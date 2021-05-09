import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    public static void main(String[] args){
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
        int[] result = anagramMappings(A,B);
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }

    public static int[] anagramMappings(int[] A, int[] B){
        //1 ds
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();

        //2 for
        for(int i=0; i < A.length; i++){
            map.put(B[i], i);
        }
        for(int i=0; i < A.length; i++){
            result[i] = map.get(A[i]);
        }
        return result;
    }
}
