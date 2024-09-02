class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)) {
            int l = 0; 
            int r = 0;

            // we can perform substring matching
            int len = needle.length();

            for(int i = 0; i < haystack.length(); i++) {
                String value = haystack.substring(i, i + len);
                
                if(value.equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }
}