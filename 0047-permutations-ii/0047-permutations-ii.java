class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void helper(int[] nums, boolean[] used, List<Integer> comb) {
        if (comb.size() == nums.length) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            //same number but havent used still soooo 
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            comb.add(nums[i]);

            helper(nums, used, comb);

            comb.remove(comb.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
}