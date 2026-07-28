class Solution {
    public boolean validPalindrome(String s) {
        /*Brute Force*/
        int n = s.length();
        if (isPalindrome(s))
            return true;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                sb.append(s.charAt(j));
            }
            String temp = sb.toString();
            if (isPalindrome(temp))
                return true;
        }
    return false;
    }

    private boolean isPalindrome(String str) {
        int n = str.length();

        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(n - 1 - i);
        }
        return Arrays.equals(arr, str.toCharArray());
    }
}

------------------------------------------------
class Solution {
    public boolean validPalindrome(String s) {
        /*Optimize*/
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
