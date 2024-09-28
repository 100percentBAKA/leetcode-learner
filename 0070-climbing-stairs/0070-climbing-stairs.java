// we can take only 1 or 2 steps

class Solution {
    static int ref(int n, int[] arr) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(arr[n] != -1) return arr[n];

        int one = ref(n - 1, arr);
        int two = ref(n - 2, arr);

        arr[n] = one + two;

        return arr[n];
    }

    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        
        return ref(n, arr);
    }
}