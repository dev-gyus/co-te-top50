public class TrappingRainWater {
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solve(height));
    }
    public static int solve(int[] height){
        //1
        int result = 0;
        if(height == null || height.length <= 2) return result;

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        //2 left
        int max = height[0];
        left[0] = height[0];
        for(int i=1; i < height.length; i++){
            if(max < height[i]){
                left[i] = height[i];
                max = height[i];
            }else{
                left[i] = max;
            }
        }

        //2 right
        max = height[height.length - 1];
        right[height.length-1] = height[height.length - 1];
        for(int i=height.length-2; i >= 0; i--){
            if(max < height[i]){
                max = height[i];
                right[i] = height[i];
            }else{
                right[i] = max;
            }
        }

        //3
        for(int i=0; i < height.length; i++){
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
