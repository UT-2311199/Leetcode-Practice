class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*Brute Force*/
        /*
        int n = nums.length;
        int[] res = new int [n - k + 1];
        for(int i = 0; i <= n - k ; i++){
            int maxNum = nums[i];
            for(int j = i; j < i + k; j++){
                maxNum = Math.max(maxNum, nums[j]);
            }
            res[i] = maxNum;
        }
        return res;
        */
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int right = 0; right < n; right++) {
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(right);
            if (right >= k - 1) {
                res[right - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
