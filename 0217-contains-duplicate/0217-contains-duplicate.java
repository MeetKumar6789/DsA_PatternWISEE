 class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            int m = nums[i];
            map.put(m, map.getOrDefault(m, 0) + 1);

            if (map.get(m) > 1) {
                return true;
            }
        }

        return false;
    }
}