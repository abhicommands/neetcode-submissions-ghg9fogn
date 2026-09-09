class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if(x == '[' || x == '(' || x == '{') stack.push(x);
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if ((x == ')' && top != '(') || (x == ']' && top != '[') || (x == '}' && top != '{')) return false;
            }
        }
        return stack.isEmpty();
    }
}
