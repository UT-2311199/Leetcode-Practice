class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int prod = 1;
            for(int j = i; j < n ; j++){
                prod *= nums[j];
                maxProduct = Math.max(maxProduct,prod);
            }
        }
        return maxProduct;
    }
}

---------------------------------------

class Solution {
    public int maxProduct(int[] nums) {
        /*Optimized*/
        int prefix = 1;
        int sufix = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(prefix == 0) prefix = 1;
            if(sufix == 0) sufix = 1;

            prefix *= nums[i];
            sufix *= nums[n - i - 1];
            ans = Math.max(ans,Math.max(prefix,sufix));
        }
        return ans;
    }
}
