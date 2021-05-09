public class PlusOne {
    public static void main(String[] args){
//        int[] digits = {1,2,3};
        int[] digits = {9,0,0,8};

        int[] result = plusOne(digits);
        for(int i : result){
            System.out.println("val = " + i);
        }
    }
    public static int[] plusOne(int[] digits){
        //1 ds
        int index = digits.length - 1; // 2
        int carry = 1;

        //2 for or while
        while(index >= 0 && carry > 0){
            digits[index] = (digits[index] + 1) % 10; // 핵심
            if(digits[index] == 0){
                if(index == 0) {
                    int[] newArray = new int[digits.length + 1];
                    newArray[0] = 1;
                    for(int i=1; i < digits.length; i++){
                        newArray[i] = digits[i];
                    }
                    digits = newArray;
                }
            }else{
                carry = 0;
            }
            index--;
        }
        return digits;
    }
}
