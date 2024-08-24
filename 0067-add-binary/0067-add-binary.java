import java.math.BigInteger;

class Solution {
    // static Integer convert(String str) {
    //     int sum = 0;
    //     int k = 0;

    //     for(int i = str.length() - 1; i >= 0; i--) {
    //         int value = str.charAt(i) - '0';
    //         sum += value * (Math.pow(2, k++));
    //     }

    //     return sum;
    // }

    public String addBinary(String a, String b) {
        // int value1 = convert(a);
        // int value2 = convert(b);

        // return Integer.toBinaryString(value1 + value2);

        BigInteger value1 = new BigInteger(a, 2);
        BigInteger value2 = new BigInteger(b, 2);

        return value1.add(value2).toString(2);
    }
}