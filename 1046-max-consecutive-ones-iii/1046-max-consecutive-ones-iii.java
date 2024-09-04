class Solution {
    public int longestOnes(int[] nums, int k) { 
        int max = 0;
        int l = 0, r = 0, count = 0, prev = 0;

        for(; r < nums.length; r++) {
            if(nums[r] == 0) {
                count++;
            }

            if(count > k) {
                prev = nums[l];
                l++;
                
                if(prev == 0) {
                    count--;
                }
            }

            // if(nums[r] == 0) {
            //     arr[0] = r;
            // }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}