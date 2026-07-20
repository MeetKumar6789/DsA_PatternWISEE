 class Solution {
    public int maxNumberOfBalloons(String text) {
        // making our have hashmap from input and below it is our need map 
        HashMap<Character, Integer> have = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            have.put(c, have.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> need = new HashMap<>();
        need.put('b', 1);
        need.put('a', 1);
        need.put('o', 2);
        need.put('l', 2);
        need.put('n', 1);

        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            char c = entry.getKey();
            int fneed = entry.getValue();
            int fhave = have.getOrDefault(c, 0);
            int times = fhave / fneed;
            res = Math.min(res, times);
        }
        return res;
    }
}