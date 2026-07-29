class Solution {
    public String longestPalindrome(String s) {
        /*Brute Force*/
        int n = s.length();
        String ans = "";

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalindrome(s, i, j)){
                    if((j - i + 1) > ans.length()){
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
------------------------------------------------
class Solution {
    public String longestPalindrome(String s) {
        /*Optimize*/
        int n = s.length();
        int start = 0 , end = 0;
        for(int i = 0 ; i < n; i++){
        int l1 = expand(s, i, i);
        int l2 = expand(s, i, i + 1);
        int len = Math.max(l1, l2);

        if(len > (end - start)) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
    }
    private int expand(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
