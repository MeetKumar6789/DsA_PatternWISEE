 class Solution {
    public int largestInteger(int n, int s) {
        if (s > 9 * n) return -1;
        if (s == 0) return 0;
        
        int q = s / 9;
        int r = s % 9;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) sb.append('9');
        if (r > 0) sb.append(r);
        
        int len = sb.length();
        for (int i = 0; i < n - len; i++) sb.append('0');
        
        return Integer.parseInt(sb.toString());
    }
}