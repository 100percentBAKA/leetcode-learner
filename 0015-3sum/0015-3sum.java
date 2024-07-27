class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> arr = new HashSet<>();

        Arrays.sort(nums);
        int sum = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    arr.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                    j++;
                    k--;
                }
                else if(sum > 0) k--;
                else j++;
            }
        }

        return new ArrayList<>(arr);
    }
}