class Solution {
    public int countSubstrings(String s) {
        /*Brute Force*/
        int count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            String sub = "";
            for(int j = i; j < n; j++){
                sub += s.charAt(j);
                if(isPalindrome(sub, 0, sub.length() - 1)) count++;
            }
        }
        return count;
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
----------------------------------------------
class Solution {
    public int countSubstrings(String s) {
        /*Optimize*/
        int count = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            count += expand(s,i,i);
            count += expand(s, i, i + 1);
        }
        return count;
    }
    private int expand(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
