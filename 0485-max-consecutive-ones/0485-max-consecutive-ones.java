class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int counter = 0;

        for(int element: nums) {
            if(element == 1) {
                counter++;
            }
            else {
                counter = 0;
            }

            max = Math.max(max, counter);
        }

        return max;
    }
}