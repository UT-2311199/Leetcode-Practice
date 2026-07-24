class Solution {
    public int maxSubArray(int[] nums) {
        /*Brute Force*/
        int maxSubarray = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                maxSubarray = Math.max(maxSubarray,sum);
            }
        }
        return maxSubarray;
    }
}

----------------------------------------

class Solution {
    public int maxSubArray(int[] nums) {
        /*Optimized*/
        int maxSum = nums[0];
        int currSum = 0;

        for(int n : nums){
            currSum += n;
            maxSum = Math.max(maxSum,currSum);

            if(currSum < 0){
                currSum = 0;
            }
        }
    return maxSum;    
    }
}
