class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int b = 0;
        int result = Integer.MAX_VALUE;
        int window_state = 0;

        for(int e = 0; e < nums.length; ++e){ // [2,3,1,2,*4,3*] => 7
            window_state += nums[e];

            while(window_state >= target){
                int window_size = e - b + 1;
                result = Math.min(result, window_size);
                window_state -= nums[b];
                ++b;
            }
        }

        if (b == 0) return 0;

        return result;  
    }
}
