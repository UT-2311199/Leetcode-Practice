class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*Brute Force*/
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            ans[i] = product;
        }
        return ans;
    }
}

----------------------------------------------------------------

class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*Optimized*/
        int n = nums.length;
        int[] ans = new int [n];

        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[ i - 1] * nums[i - 1];
        }
        int prod = 1;

        for(int r = n -1; r >= 0; r--){
            ans[r] = ans[r] * prod;
            prod *= nums[r];
        }
        return ans;
    }
}
