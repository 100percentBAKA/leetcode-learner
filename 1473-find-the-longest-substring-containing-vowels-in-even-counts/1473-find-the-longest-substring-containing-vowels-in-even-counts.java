class Solution {
    static String process(int[] arr) {
        StringBuilder result = new StringBuilder();

        for(int e: arr) {
            result.append(String.valueOf(e));
        }

        return result.toString();
    }

    public int findTheLongestSubstring(String s) {
        int[] arr = new int[5];
        int mx = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("00000", -1);

        for(int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);

            if(value == 'a') {
                arr[0] = (arr[0] + 1) % 2;
            }
            else if(value == 'e') {
                arr[1] = (arr[1] + 1) % 2;
            }
            else if(value == 'i') {
                arr[2] = (arr[2] + 1) % 2;
            }
            else if(value == 'o') {
                arr[3] = (arr[3] + 1) % 2;
            }
            else if(value == 'u') {
                arr[4] = (arr[4] + 1) % 2;
            }

            String ref = process(arr);

            if(map.containsKey(ref)) {
                mx = Math.max(mx, i - map.get(ref));
            }
            else {
                map.put(ref, i);
            }
        }

        return mx;
    }
}