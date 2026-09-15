 class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(0, nums, temp, res);
        return res;
    }
    
    public void backTrack(int idx, int[] nums, List<Integer> temp, List<List<Integer>> res) {
        // Base case: when we reach the end of the array, add the current subset copy
        if (idx == nums.length) {
            res.add(new ArrayList<>(temp)); // Add a copy of temp
            return;
        }
        
        // Case 1: Not include nums[idx]
        backTrack(idx + 1, nums, temp, res);
        
        // Case 2: Include nums[idx]
        temp.add(nums[idx]);
        backTrack(idx + 1, nums, temp, res);
        temp.remove(temp.size() - 1); // Backtrack
    }
}
