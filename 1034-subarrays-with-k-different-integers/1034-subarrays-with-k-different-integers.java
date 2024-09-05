class Solution {
    static int helper(int[] arr, int k) {
        int result = 0, r = 0, l = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(; r < arr.length; r++) {
            int key = arr[r];

            if(!map.containsKey(key)) {
                map.put(key, 1);
                count++;
            }
            else {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            while(count > k) {
                int value = arr[l];
                map.put(value, map.get(value) - 1);

                if(map.get(value) == 0) {
                    map.remove(value);
                    count--;
                }

                l++;
            }

            result += (r - l + 1);
        }

        return result;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return (helper(nums, k) - helper(nums, k - 1));
    }
}