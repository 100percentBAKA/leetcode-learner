class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        long copy = n;
        boolean flag = false;

        if(n < 0) {
            copy = Math.abs((long) n); // n can be -2^31 and abs can lead to integer overflow 
            flag = true; // yes, n is negative
        }

        // while(copy > 0) {
        //     if(copy % 2 == 0) {
        //         x *= x;
        //         copy /= 2;
        //     }
        //     else {
        //         result *= x;
        //         copy -= 1;
        //     }
        // }

        result = pow(x, copy);

        return flag ? 1.0 / result : result;
    }

    static double pow(double base, long power) {
	    if(power == 0) return 1;
	    if(power % 2 == 0) return pow(base * base, power / 2);
	    return base * pow(base, power - 1);
	}
}