class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int p = 0, n = 1;
        
        for (int e : nums) {
            if (e > 0) {
                result[p] = e;
                p += 2;
            } else {
                result[n] = e;
                n += 2;
            }
        }

        return result;
    }
}
