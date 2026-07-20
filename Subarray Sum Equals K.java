class Solution {
    public int subarraySum(int[] nums, int k) {
        /*Brute Force*/
        /*
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
        */

        /*Optimized*/

        HashMap<Integer,Integer> map = new HashMap<>();
        
        map.put(0, 1);
        int count = 0;
        int prefixSum = 0;
        for(int n : nums){
            prefixSum += n;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
