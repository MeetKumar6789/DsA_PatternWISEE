class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer>res = new ArrayList<>();
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int x = nums[i];
         map.put(x,map.getOrDefault(x,0)+1);
        }

       for(Map.Entry<Integer,Integer>entry : map.entrySet())
       {
        int value = entry.getValue(); // gets the freq of the integers
        if(value>1)
        {
        res.add(entry.getKey());
        }

       }
       return res;

        
    }
}