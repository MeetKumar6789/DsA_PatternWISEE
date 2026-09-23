class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void helperFun(int[] nums, boolean[] used, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp)); // Make a copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip if already used
            
            used[i] = true;
            tmp.add(nums[i]);
            
            helperFun(nums, used, tmp);
            
            tmp.remove(tmp.size() - 1); // Backtrack
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        helperFun(nums, used, new ArrayList<>());
        return res;
    }
}
