class Solution {
    class Pair
    {
        int first;//freq
        String second; //string;

        public Pair(int first , String second )
        {
            this.first= first;
            this.second = second;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character, Integer>map = new HashMap<>();
       for(int i=0;i<s.length();i++)
       {
        char c = s.charAt(i);
        map.put(c,map.getOrDefault(c,0)+1);
       }

       PriorityQueue<Pair>pq = new PriorityQueue<>(
   
              (a,b) -> {
                if(b.first!=a.first)return b.first - a.first;//max on frequency 
                return a.second.compareTo(b.second);//min on second
              }      
       );
 for (Map.Entry<Character, Integer> entry : map.entrySet()) {
    char x = entry.getKey();      // the character
    int y = entry.getValue();     // its frequency
    pq.add(new Pair(y, String.valueOf(x)));
}

     StringBuilder sb = new StringBuilder();

     while(pq.size()>=2)
     {
      Pair p1 = pq.poll(); // first most frequent
      Pair p2 = pq.poll(); //second most frequent

      sb.append(p1.second);
      sb.append(p2.second);

      p1.first--;
      p2.first--;

      //till they are zero
      if(p1.first>0)
      {
        pq.add(p1);
      }
      if(p2.first>0)
      {
        pq.add(p2);
      }
     }

     if(!pq.isEmpty())
     {
        Pair last = pq.poll();
        if(last.first>1)
        {
            return "";
        }
        sb.append(last.second);
     }
     return sb.toString();
    }
}