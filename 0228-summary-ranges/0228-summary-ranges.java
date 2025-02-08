class Solution {
    public List<String> summaryRanges(int[] num) {
        ArrayList<Long> nums = new ArrayList<>();
        for(int element: num) {
            nums.add((long) element);
        }

        nums.add(Long.MAX_VALUE);

        ArrayList<String> result = new ArrayList<>();

        int l = 0, r = 1;

        for(; r < nums.size(); r++) {
            if(nums.get(r - 1) != nums.get(r) - 1) {

                if(l == (r - 1)) {
                    result.add(nums.get(l) + "");
                }
                else {
                    result.add(nums.get(l) + "->" + nums.get(r - 1));
                }

                l = r;
            }
        }

        return result;
    }
}