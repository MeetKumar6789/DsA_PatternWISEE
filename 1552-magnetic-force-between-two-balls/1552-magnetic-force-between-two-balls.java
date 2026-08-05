class Solution {
    public boolean cows(int []position , int m , int guess , int n)
    {   
        int cows = 1;   // ek gaay ko set kr diye  --- > 
        int prev = position[0];
        for(int i=0;i<n;i++)
        {   
            int dist = position[i] - prev;
            if(dist<guess)
            {
                continue;
            }
            else
            {
                cows++;
                prev = position[i];
            }
        }
     if(cows>=m) return true;
     return false;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n-1] - position[0];
        int res = -1;
        while(low<=high)
        {
            int guess = low + (high - low)/2;
            if(cows(position , m , guess ,n))
            {
                res = guess;   //right side jana pdega
                low = guess +1;   
            }
            else
            {
                high = guess -1;
            }
        }
        return res;
    }
}