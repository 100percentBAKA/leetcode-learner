class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> n = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                p.add(nums[i]);
            }
            else {
                n.add(nums[i]);
            }
        }

        int[] result = new int[nums.length];
        int index = 0;

        while(!p.isEmpty() && !n.isEmpty()) {
            result[index++] = p.poll();  
            result[index++] = n.poll();  
        }

        return result;
    }
}
