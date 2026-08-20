class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer , Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {   
            int n = nums[i];
            map.put(n , map.getOrDefault(n,0)+1);
        }
         int ans = 0;
        for(Map.Entry<Integer , Integer>entry : map.entrySet())
        {
            int n = entry.getKey();
            int m = entry.getValue();
            if(m==1)
            {
               ans = n;
            }
        }
      return ans;
    }
}