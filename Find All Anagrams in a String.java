class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /*Brute Force*/
        List<Integer> res = new ArrayList<>();

        int n = s.length();
        int k = p.length();

        int[] count = new int[26];
        for(char c : p.toCharArray()){
            count[c - 'a']++;
        }

        for(int i = 0; i <= n - k; i++){
            int[] sCount = new int[26];
            for(int j = i; j <= i + k - 1; j++){
                sCount[s.charAt(j) - 'a']++;
            }
            if(Arrays.equals(count, sCount)){
                res.add(i);
            }
        }
        return res;
    }
}
