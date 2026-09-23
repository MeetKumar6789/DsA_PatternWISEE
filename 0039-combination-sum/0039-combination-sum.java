class Solution {
    List<List<Integer>>res =new ArrayList<>();
    public void helperFun(int []nums, int target , int idx , List<Integer>sum)
    {  
        if (target == 0) {
            res.add(new ArrayList<>(sum));
            return;
        }

        if (target < 0 || idx == nums.length) {
            return;
        }
        
        sum.add(nums[idx]);
        //included the current element and also we can reuse the elemnt so idx = idx
        helperFun(nums , target - nums[idx] , idx , sum);
        
        sum.remove(sum.size()-1);
        //excluded the current elemnt
        helperFun(nums , target , idx + 1, sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();
        helperFun(candidates, target , 0 , new ArrayList<>());
        return res;
    }
}