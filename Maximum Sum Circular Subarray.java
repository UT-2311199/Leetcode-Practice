class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /*Brute Force*/
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n ; j++){
                int len = (i + j) % n; // Calculate Actual index.
                sum += nums[len];
                maxSum = Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
}
----------------------------------------------------
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /*Optimized*/
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = 0;
        int currSum = nums[0];
        int currMinSum = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
            currMinSum = Math.min(nums[i], currMinSum + nums[i]);
            minSum = Math.min(minSum, currMinSum);
        }
        if (maxSum < 0)
            return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}
