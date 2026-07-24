class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int times = (nums.length)/2;

        for(int i =0;i<nums.length;i++)
        {
            int x = nums[i];
            map.put(x,map.getOrDefault(x,0)+1);
        }

        for(Map.Entry<Integer,Integer>entry : map.entrySet())
        {    
            int y = entry.getKey();
            if(entry.getValue()>times)
            {
                return y;
            }
        }
   return -1;
       
 
    }
}
    