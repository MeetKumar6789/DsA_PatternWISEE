class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int idx, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(curr)); // copy — critical, see below
            return;
        }
        backtrack(idx + 1, nums, curr, result);           // exclude nums[idx]
        curr.add(nums[idx]);
        backtrack(idx + 1, nums, curr, result);            // include nums[idx]
        curr.remove(curr.size() - 1);                       // backtrack
    }
}