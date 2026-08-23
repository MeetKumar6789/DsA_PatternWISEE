class Solution {
     class Pair
    {
        String first; //word
        int second;   // freq
        public Pair(String first , int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>(); 
        for(String word:words)
        {
            map.put(word , map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.second!=b.second)
                {
                    return a.second - b.second;
                }
                return b.first.compareTo(a.first);
            }
        );

        for(Map.Entry<String,Integer>entry : map.entrySet())
        {
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }

        ArrayList<String>res = new ArrayList<>();
        while(!pq.isEmpty())
        {
            res.add(0,pq.poll().first);
        }
        return res;
    }

}