class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /*Brute Force */
        /*
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            int sum = 0;
            for(int j = i; j < n;j++){
                sum += nums[j];
                if(sum >= target){
                    int len = j - i + 1;
                    ans = Math.min(ans, len);
                    break;
                }
            }
            if(ans == Integer.MAX_VALUE) return 0;
        }
        return ans;
        */
        
        /*Optimized*/
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            sum += nums[right];
            while(sum >= target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
