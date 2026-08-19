class Solution {
    int isTrue(int[][] matrix,int n ,int m, int k , int guess)
    {   
        int row = n-1;
        int col = 0 , count = 0;
         while(row>=0 && col<m)
         {
            if(matrix[row][col]>guess)
            {
              row--;
            }
            else
            {
                count = count + row + 1; //cause we have to consider it tooo
                col++;
            }
         }
return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length , m = matrix[0].length;;
        int res = -1;
        int low = matrix[0][0] , high = matrix[n-1][m-1];

        while(low<=high)
        {   
            int guess = low + (high - low)/2;
           int ans = isTrue(matrix , n , m , k , guess);
           //typicall first occr ... . . . 
           if(ans>=k)
           {
             res = guess;
             high = guess -1;
           } 
           else{
 low  = guess +1;
           }
        }
        return  res;
    }
}