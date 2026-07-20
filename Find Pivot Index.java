class Solution {
    public int pivotIndex(int[] nums) {
        /*Brute Force*/
        /*
        int n = nums.length;
        
        for(int i = 0 ; i < n-1;i++){
            int sumLeft = 0;
        
            for(int j = 0; j < i; j++){
                sumLeft += nums[j];
            }
        
            int sumRight = 0;
            for(int k = i+1; k < n; k++){
                sumRight += nums[k];
            }
            if(sumLeft == sumRight){
                return i;
            }
        }
        return -1;
        */

        /*Optimized*/
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }
        int n = nums.length;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
