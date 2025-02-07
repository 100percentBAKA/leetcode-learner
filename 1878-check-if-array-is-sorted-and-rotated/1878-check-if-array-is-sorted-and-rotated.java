class Solution {
    public boolean check(int[] nums) {
        int left = 0, right = 0;
        boolean flag = false; // false --> no we have not found the point

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
                flag = true; // found the point
                left = i - 1;
                right = i;

                break;
            }
        }

        if(flag) {
            // find the min of leftArr and max of rightArr
            int min = nums[0];
            for(int i = 1; i <= left; i++) {
                if(nums[i - 1] > nums[i]) {
                    return false;
                }
                min = Math.min(min, nums[i]);
            }

            int max = nums[right]; 
            for(int i = right + 1; i < nums.length; i++) {
                if(nums[i - 1] > nums[i]) {
                    return false;
                }
                max = Math.max(max, nums[i]);
            }

            return (min < max) ? false : true;
        }

        return true;
    }
}