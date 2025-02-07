class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // return elements common to both arrays
        HashSet<Integer> arr = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {

                if(nums1[i] == nums2[j]) {
                    arr.add(nums1[i]);
                }
            }
        }

        int[] result = new int[arr.size()];
        int counter = 0;

        for(Integer i : arr) {
            result[counter++] = i;
        }

        return result;
    }
}