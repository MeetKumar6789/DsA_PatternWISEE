class Solution {
    public int maxProfit(int[] prices) { 
        if(prices==null || prices.length ==0) return 0;

        int min = prices[0];
        int maxProfit = 0;
        int n = prices.length;
        for(int i=0;i<n;i++)
        {
            if(min>prices[i])
            {
                min = prices[i]; //gotcha the smallest element 
            }
            else if(prices[i] - min > maxProfit)
            {
                maxProfit = prices[i] - min;
                 
            }
        }  
        return maxProfit;
  }
}