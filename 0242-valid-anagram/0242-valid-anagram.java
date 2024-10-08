class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char element: s.toCharArray()) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        
        for(char element: t.toCharArray()) {
            map.put(element, map.getOrDefault(element, 0) - 1);
        }

        for(int val : map.values()) {
            if(val != 0) return false;
        }

        return true;
    }
}