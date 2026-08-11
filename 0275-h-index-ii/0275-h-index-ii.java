class Solution {
    public int hIndex(int[] citations)
     {   int n = citations.length;
        int low = 0 , high = n-1;
         int res = n;
        while(high >= low )
        {
            int guess = low + (high - low)/2;
            int minPapers = n - guess;
           
            if(citations[guess]>=minPapers)
            {
                res = guess;
                high = guess -1;
            }
            else
            {
                low = guess + 1;
            }
        }
        return n - res; // convert index -> actual h-index count
        }
}