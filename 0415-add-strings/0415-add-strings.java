class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int n = num1.length() - 1;
        int m = num2.length() - 1;

        int carry = 0;

        while(n >= 0 || m >= 0 || carry > 0) {
            int v1 = n < 0 ? 0 : num1.charAt(n--) - '0';
            int v2 = m < 0 ? 0 : num2.charAt(m--) - '0';

            int sum = v1 + v2 + carry;
            result.append((char)((sum % 10) + '0'));

            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}
