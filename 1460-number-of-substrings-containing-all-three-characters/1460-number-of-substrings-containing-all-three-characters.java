class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int min = 0;
        int count = 0;
        
        int[] arr = new int[3];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] = i;
            
            if (arr[0] != -1 && arr[1] != -1 && arr[2] != -1) {
                min = Math.min(arr[0], Math.min(arr[1], arr[2]));
                count += min + 1;
            } else {
                // window will not be formed until this point
                System.out.println("Window has not yet been formed");
            }
        }
        
        return count;
    }
}
