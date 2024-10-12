// class Solution {
//     public String minWindow(String s, String t) {
//         Map<Character, Integer> map = new HashMap<>();

//         for(char i: t.toCharArray()) {
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }

//         int len = s.length();
//         int target = t.length();
//         int min = Integer.MAX_VALUE;
//         int startingIndex = -1;

//         for(int i = 0; i < len; i++) {
//             int count = 0;
//             // maintain another temp map, if not the values in the original map changes after each iteration
//             Map<Character, Integer> tempMap = new HashMap<>(map);

//             for(int j = i; j < len; j++) {
//                 char key = s.charAt(j);

//                 if(tempMap.containsKey(key)) {
//                     int freq = tempMap.get(key);

//                     if(freq > 0) {
//                         count++;
//                     }
                    
//                     tempMap.put(key, freq - 1);
//                 }

//                 if(count == target) {
//                     if(min > (j - i + 1)) {
//                         startingIndex = i;
//                         min = (j - i + 1);
//                     }

//                     break;
//                 }
//             }
//         }

//         return startingIndex == -1 ? "" : s.substring(startingIndex, startingIndex + min);
//     }
// }

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char e : t.toCharArray()) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        int target = t.length();

        int right = 0;
        int left = 0;

        int count = 0;
        int startingIndex = -1;
        int min = Integer.MAX_VALUE;

        while(right < s.length()) {
            char key = s.charAt(right);

            if(map.containsKey(key)) {
                int freq = map.get(key);

                if(freq > 0) {
                    count++;
                }

                map.put(key, freq - 1);
            }

            while(count == target) { // left <= right

                // calc starting index and len here . . . 
                if(min > (right - left + 1)) {
                    min = right - left + 1;
                    startingIndex = left;
                }

                char newKey = s.charAt(left);
                if(map.containsKey(newKey)) {
                    int newFreq = map.get(newKey);

                    if(newFreq == 0) {
                        count--;
                    }
                    map.put(newKey, newFreq + 1);
                }

                left++;
            }

            right++;
        }

        return startingIndex == -1 ? "" : s.substring(startingIndex, min + startingIndex);
    }
}