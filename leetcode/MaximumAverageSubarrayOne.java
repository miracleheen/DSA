class MaximumAverageSubarrayOne{
    public double findMaxAverage(int[] nums, int k) {
        double window_state = 0;
        double result = Double.NEGATIVE_INFINITY;
        int b = 0;
        
        for(int e = 0; e < nums.length; ++e){
            window_state += nums[e];
            if(e - b + 1 == k){// 3 - 0 + 1 == 4
                result = Math.max(result, window_state);
                window_state -= nums[b];
                ++b;
            }
        }

        return result / k;
    }
}