class Solution {
    static int ref(int x, int y, String str1, String str2, int[][] arr) {
        if(x < 0 || y < 0) return 0;

        if(arr[x][y] != -1) return arr[x][y];

        if(str1.charAt(x) == str2.charAt(y)) {
            arr[x][y] = 1 + ref(x - 1, y - 1, str1, str2, arr);
            return arr[x][y];
        }

        arr[x][y] = 0 + Math.max(ref(x - 1, y, str1, str2, arr), ref(x, y - 1, str1, str2, arr));
        return arr[x][y];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] arr = new int[text1.length()][text2.length()];   

        Arrays.stream(arr).forEach(col -> Arrays.fill(col, -1));

        return ref(text1.length() - 1, text2.length() - 1, text1, text2, arr);
    }
}