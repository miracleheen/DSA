/**
 * MaxConsecutiveOnesThree
 */
class MaxConsecutiveOnesThree {
     public int longestOnes(int[] nums, int k) {
        int b = 0;
        int window_state = 0; //how much 0?
        int result = 0;
        int e = 0;

        for(; e < nums.length; ++e){ 
            if(nums[e] == 0) 
                window_state++;

            while(window_state > k){ 
                if(nums[b] == 0){
                    --window_state;
                }
                ++b;
            }

            result = Math.max(result, e - b + 1); 
        }

        return result;
    }
}