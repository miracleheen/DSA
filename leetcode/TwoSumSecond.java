class TwoSumSecond{
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target){
                return new int[]{left + 1, right + 1};
            }

            if(sum > target) right--;
            else left++;
        }

        return new int[]{0};
    }
}
            //  target = 7
            //         *    
            //  [2 5 7 8 11]  => 10   
            //   * 
            // O(n), memory O(1)