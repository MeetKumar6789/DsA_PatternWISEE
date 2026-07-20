class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character , Integer>f =  new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            f.put(c,f.getOrDefault(c,0)+1);
        }

        boolean odd = false; // just for validation of the odd freq char
        int res = 0;
        for(Map.Entry<Character,Integer>entry : f.entrySet())
        {
            int value = entry.getValue(); // cause we need the freq
            if(value%2==0)
            {
                res+=value;
            }
            else
            {
                odd = true; //now validation true for the odd freq 
            }
        }
         if(odd == false)
         {
            return res;
         }
         else
         {
            for(Map.Entry<Character,Integer>entry1 : f.entrySet())
            {
                int value = entry1.getValue();
                if(value%2==1)
                {
                    res=res + value-1; // cause we are here now taking only the pairs 
                 }
            }
         }
        return res+1;
    }
}