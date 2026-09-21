class Solution {

    public void parenTheses(int close, int open, int n, StringBuilder temp, List<String> res) {
        // base case
        if (open == n && close == n) {
            res.add(temp.toString());
            return;
        }

        // add '(' if we still have some left
        if (open < n) {
            temp.append('(');
            parenTheses(close, open + 1, n, temp, res);
            temp.deleteCharAt(temp.length() - 1); // backtrack
        }

        // add ')' only if it won't exceed the number of '('
        if (close < open) {
            temp.append(')');
            parenTheses(close + 1, open, n, temp, res);
            temp.deleteCharAt(temp.length() - 1); // backtrack
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        parenTheses(0, 0, n, new StringBuilder(), res);
        return res;
    }
}