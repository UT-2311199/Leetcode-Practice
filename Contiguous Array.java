class Solution {
    public int findMaxLength(int[] nums) {
        /*brute Force*/
        int n = nums.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int ones = 0;
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
     return maxLength;
    }
}

------------------------------------------------------

class Solution {
    public int findMaxLength(int[] nums) {
        /*Optimized*/
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++){
             if (nums[i] == 1)
                prefixSum++;
            else
                prefixSum--;
    

            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
    return maxLength;
    }
}
