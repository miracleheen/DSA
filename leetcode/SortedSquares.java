class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for(int i = n - 1; i >= 0; --i){ 
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                result[i] = nums[right] * nums[right]; // |-2| < |5|
                right--;
            } else {
                result[i] = nums[left] * nums[left]; // |-10| > |8|
                left++;
            }
        }

        return result;
    }
}
