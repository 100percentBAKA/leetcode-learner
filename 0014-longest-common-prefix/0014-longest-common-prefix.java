class Solution {
    public String longestCommonPrefix(String[] strs) {
        // property of sorted strings is that
        // the first and the last string will either have the longest prefix or the shorted prefix

        Arrays.sort(strs);

        int min = Math.min(strs[0].length(), strs[strs.length - 1].length());
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < min; i++) {
             if(strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
             }
             result.append(strs[0].charAt(i));
        }

        return result.toString();
    }
}