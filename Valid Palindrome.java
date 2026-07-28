class Solution {
    public boolean isPalindrome(String s) {
        /*Brute Force*/
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
----------------------------------------------
class Solution {
    public boolean isPalindrome(String s) {
        /*Optimize*/
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(!isAlphaNum(l)){
                left++;
            }else if(!isAlphaNum(r)){
                right--;
            }else{
                if(Character.toLowerCase(l) != Character.toLowerCase(r)){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
    private boolean isAlphaNum(char c){
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }
}
