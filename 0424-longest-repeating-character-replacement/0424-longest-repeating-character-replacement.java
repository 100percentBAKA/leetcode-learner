class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int max = 0;
        int ref = 0;
        int j = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'A']++;

            ref = Math.max(ref, arr[c - 'A']);
            int len = i - j + 1;

            if(len - ref > k) {
                // shrink window
                arr[s.charAt(j) - 'A']--;
                j++;
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}