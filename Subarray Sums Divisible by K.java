class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       /*Brute Force*/
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum % k == 0){
                    count++;
                }
            }
        }
        return count;
    }
}

----------------------------------------------------

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        /*Optimized*/
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0 , 1);
        int count = 0;
        int prefixSum = 0;
        for (int n : nums) {
            prefixSum += n;
            int rem = prefixSum % k;
            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
    return count;
    }
}
