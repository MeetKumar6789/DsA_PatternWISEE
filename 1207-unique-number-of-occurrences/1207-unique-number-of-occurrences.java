class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++)
        {  
            int n = arr[i];
            map.put(n,map.getOrDefault(n,0)+1);
        }

   HashMap<Integer, Integer> countMap = new HashMap<>();

        for(Map.Entry<Integer,Integer>entry :map.entrySet())
        {
            int key = entry.getValue();
            if(countMap.containsKey(key))
            {
                return false;
            }
            countMap.put(key,1); //just freq ++
        }
       return true;
    }
}