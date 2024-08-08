class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }

            else {
                // check for the starting of the string for "}", ")", "]"
                if(stack.isEmpty()) {
                    return false;
                }

                Character ref = stack.pop();

                if(c == ']' && ref != '[' || c == '}' && ref != '{' || c == ')' && ref != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}