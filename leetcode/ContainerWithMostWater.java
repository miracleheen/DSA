class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int  right = height.length - 1;
        int result = 0;
        
        while(left < right){
            int sum = Math.min(height[left], height[right]) * (right - left);
            if(sum > result){
                result = sum;
            } 

            if(height[left] < height[right]){
                left++; 
            } else {
                right--;
            }
        }

        return result;
    }
}
