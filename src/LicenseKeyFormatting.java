import java.util.Locale;

public class LicenseKeyFormatting {
    public static void main(String[] args){
        String str = "8F3Z-2e-9-w";
//        String str = "8-5g-3-J";
        int k=4;
        System.out.println(solve(str, k));
    }
    public static String solve(String str, int k){
        String newStr = str.replace("-", "");
        String upperStr = newStr.toUpperCase(Locale.ROOT);

        int leng = upperStr.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < leng; i++){
            sb.append(upperStr.charAt(i));
        }

        for(int i = k; i < leng; i=i+k){
            sb.insert(leng-i, '-');
        }

        return sb.toString();
    }
}
