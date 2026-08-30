class Solution {
    class Pair{
        int first; //freq of the particular char as the String 
        String second; //char as the String 

        public Pair(int first , String second)
        {
            this.first = first;
            this.second = second; 
        }
    }
   
    public String reorganizeString(String s) {
       HashMap<Character,Integer>map = new HashMap<>();
       for(int i=0;i<s.length();i++)
       {
        char c = s.charAt(i);
        map.put(c,map.getOrDefault(c,0)+1);
       }

      
       PriorityQueue<Pair>pq = new PriorityQueue<>(
        (a,b) -> {
            if(b.first!= a.first)
            {
                return b.first-a.first; //Max on the freq
            }
            return a.second.compareTo(b.second); //Min on the char 
        }
       );


      for(Map.Entry<Character,Integer>entry : map.entrySet()){
        char x = entry.getKey(); //the real char
        int y = entry.getValue(); //da real freq of the char 
        pq.add(new Pair(y , String.valueOf(x)));
      }

     StringBuilder sb =  new StringBuilder();

      while(pq.size()>=2)
      {
        //taking the top 2 
        Pair p1 = pq.poll();
        Pair p2 = pq.poll();

        sb.append(p1.second); //append the char only 
        sb.append(p2.second); //append the char only 

         //decrementing the freq
         p1.first--;
         p2.first--;

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
        //still one char of the string is there:
        Pair last = pq.poll();
        if(last.first>1)
        {
            return "";//returning the null string cause if the element at the last have the freq >1 then both of teh last char are gonna be identical 
        }
        sb.append(last.second);
      }
     
        return sb.toString();
    }
}