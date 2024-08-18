class Solution {
    static boolean checkPalindrome(String sub) {
        int l = 0;
        int r = sub.length() - 1;

        while(l < r) {
            if(sub.charAt(l) != sub.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }


    public String longestPalindrome(String s) {

        String result = "";

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);

                if(checkPalindrome(sub)) {
                    result = result.length() > sub.length() ? result : sub;
                }
            }
        }      

        return result;  
    }
}