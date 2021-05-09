public class UniquePath {
    public static void main(String[] args){
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n){
        Integer[][] map = new Integer[m][n];

        for(int i=0; i < m; i++){
            map[i][0] = 1;
        }
        for(int j=0; j < n; j++){
            map[0][j] = 1;
        }

        for(int k=1; k < m; k++){
            for(int l=1; l < n; l++){
                map[k][l] = map[k][l-1] + map[k-1][l];
            }
        }
        return map[m-1][n-1];
    }

}
