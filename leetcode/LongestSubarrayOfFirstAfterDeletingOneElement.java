class LongestSubarrayOfFirstAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int b = 0;
        int window_state = 0;
        int result = 0;
        int k = 1;

        for(int e = 0; e < nums.length; ++e){ //[0,1,1,1,0,1,1,0,1]
            if(nums[e] == 0){
                ++window_state;
            }

            while(window_state > k){
                if(nums[b] == 0){
                    --window_state;
                }
                ++b;
            }

            result = Math.max(result, e - b); 
        }

        return result;
    }
}
