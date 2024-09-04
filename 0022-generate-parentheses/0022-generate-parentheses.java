class Solution {
    public static List<String> srr = new ArrayList<>();

    static void helper(int x, int y, int n, StringBuilder res) {
        if(x == y && x == n) {
            srr.add(res.toString());
            return;
        }

        if(x < n) {
            res.append('(');
            helper(x + 1, y, n, res);
            res.deleteCharAt(res.length() - 1); 
        }

        if(y < x) {
            res.append(')');
            helper(x, y + 1, n, res); 
            res.deleteCharAt(res.length() - 1); 
        }
    }

    public List<String> generateParenthesis(int n) {
        srr.clear();  
        int x = 0;
        int y = 0;
        StringBuilder res = new StringBuilder();

        helper(x, y, n, res);

        return srr;
    }
}
