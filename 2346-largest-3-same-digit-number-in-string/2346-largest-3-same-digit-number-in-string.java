class Solution {
    static boolean uniqueCheck(String str) {
        // str - "777"
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(i - 1)) return false; // false --> no the substring is not unqiue
        }

        return true;
    }

    public String largestGoodInteger(String num) {
        Long max = -1L;
        for(int i = 2; i < num.length(); i++) {
            String check = num.substring(i - 2, i + 1);
            if(uniqueCheck(check)) {
                // System.out.println(check + " passed the unique test");
                max = Math.max(max, Long.parseLong(check));
            }
        }

        if(max == -1) {
            // odd number not found
            return "";
        }
        else if(max == 0) {
            return "000";
        }

        return String.valueOf(max);
    }
}