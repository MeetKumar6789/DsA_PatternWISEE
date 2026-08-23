class Solution {

    class Pair
    {
        int first;
        int second;
        
        public Pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int num:nums)
        {
          map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>(
            (a,b) -> { //casue we want Minheap
                    return a.first - b.first; 
            }
        );
        for(Map.Entry<Integer,Integer>entry:map.entrySet())
        {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        int []res= new int[k];
        for (int i = k - 1; i >= 0; i--) {
    res[i] = pq.poll().second;
}
return res;
    }
}