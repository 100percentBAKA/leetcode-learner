class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if (len1 != len2) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> valuesSet = new HashSet<>(); 

        for (int i = 0; i < len1; i++) {
            Character key = s.charAt(i);
            Character value = t.charAt(i);

            if (map.containsKey(key)) {
                if (!map.get(key).equals(value)) return false;
            } else {
                if (valuesSet.contains(value)) return false;
                map.put(key, value);
                valuesSet.add(value);
            }
        }

        return true;
    }
}
