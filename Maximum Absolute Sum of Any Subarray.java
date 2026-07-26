class Solution {
    public int maxAbsoluteSum(int[] nums) {
        /*Brute Force*/
        int n = nums.length;
        int maxSum = nums[0];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, Math.abs(sum));

            }
        }
        return maxSum;
    }
}

-------------------------------------------

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        /*Optimized*/
        int currSum = 0;
        int currMin = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        for (int n : nums) {
            
            //Maximum Kadane
            currSum += n;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;

            //Minimum Kadane  
            currMin += n;
            minSum = Math.min(minSum, currMin);
            if (currMin > 0) 
               currMin = 0;
        }
    return Math.max(maxSum, -minSum);
    }
}
