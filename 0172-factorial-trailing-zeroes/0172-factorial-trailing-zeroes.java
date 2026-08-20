class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        int curr = 5;
        while(curr<=n)
        {
            ans = ans + n/curr;
            curr*=5;
        }
      
      return ans;  
    }
}