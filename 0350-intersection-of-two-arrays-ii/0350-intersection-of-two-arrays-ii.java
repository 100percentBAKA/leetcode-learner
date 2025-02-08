class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int element: nums1) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        // for(Integer key : map.keySet()) {
        //     System.out.println("key: " + key + " value: " + map.get(key));
        // }

        // return new int[]{0};

        ArrayList<Integer> arr = new ArrayList<>();

        for(int element: nums2) {
            if(map.containsKey(element) && map.get(element) > 0) {
                arr.add(element);
                map.put(element, map.get(element) - 1);
            }
        }

        int[] result = new int[arr.size()];
        int counter = 0;

        for(Integer element: arr) {
            result[counter++] = element;
        }

        return result;
    }
}