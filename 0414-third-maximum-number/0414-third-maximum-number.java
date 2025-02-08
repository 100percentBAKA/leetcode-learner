class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int element: nums) {
            set.add(element);
        }

        Integer[] result = new Integer[set.size()];
        int counter = 0;

        for(Integer element: set) {
            result[counter++] = element;
        }

        Arrays.sort(result, Collections.reverseOrder());

        if(result.length < 3) return result[0];

        return result[2];
    }
}