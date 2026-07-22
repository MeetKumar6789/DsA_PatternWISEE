 import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters in s
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Subtract characters from t
        for (int i = 0; i < m; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        // Check if all counts are zero
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;   // <-- This should be true
    }
}