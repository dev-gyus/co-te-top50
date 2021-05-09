import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args){
        int[][] nums = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(spiralOrder(nums));
    }
    public static List<Integer> spiralOrder(int[][] matrix){
        //1
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        //2
        while(rowStart <= rowEnd && colStart <= colEnd){
            // right
            for(int i=colStart; i <= colEnd; i++){
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // down
            for(int i=rowStart; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left
            // if붙인이유 = while문 안에서 colStart, rowStart가 내부적으로 증가해서 루프 쭉 돌다가 colStart > colEnd / rowStart > rowEnd 인 경우가 내부적으로 발생함
            // -> 출력결과 이상해짐
            if(rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // up
            if(colStart <= colEnd){
                for (int i = rowEnd; i >= rowStart; i--){
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return result;
    }

}
