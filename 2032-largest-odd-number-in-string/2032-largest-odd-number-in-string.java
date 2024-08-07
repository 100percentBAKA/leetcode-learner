class Solution {
    public String largestOddNumber(String num) {
        // iterat e from the last and check if the digit is odd
        // if odd return the substring until the identified digit

        for(int i = num.length() - 1; i >= 0; i--) {
            if(((num.charAt(i) - '0') & 1) == 1) {
                // the element is odd
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}