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
                //explaination of the test case 1
                //at i = 0 -> 7 - 7 !>0 so i++ & 
                //i = 1 , we get our minamount to take the share or best price to buy share 
                //at the idx 2 we get our fist maxProfit : 4
                //at idx 4 we get our Final maxProfit : 5
            }
        }  
        return maxProfit;
  }
}