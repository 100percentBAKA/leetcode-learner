class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = i + 1; j < nums.length; j++) {
        //         if(nums[i] == nums[j]) {
        //             if(Math.abs(i - j) <= k) {
        //                 return true;
        //             }
        //         }
        //     }
        // }

        // return false;
        Map<Integer, Integer> map = new HashMap<>();

        boolean flag = false;

        for(int i = 0; i < nums.length; i++) {
            int key = nums[i];

            if(map.containsKey(key)) {
                int index = map.get(key);
                // System.out.println(index + " current pos: " + i + " abs: " + Math.abs(i - index) + " k is: " + k);
                if(Math.abs(i - index) <= k) {
                    return true;
                }
            }
            map.put(key, i);
        }

        return false;
    }
}