 class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Count characters in string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Check characters in string t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            // If character is missing or count is 0, this is the extra character
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;
            }
            map.put(c, map.get(c) - 1);
        }
        
        return ' ';
    }
}
