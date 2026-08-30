class Solution {
    private int countSoldiers(int []row)
    {
        int count= 0;
        for(int val:row)
        {
           if(val==1)
           {
            count++;
           }
           else
           {
            break;
           }
        }
        return count;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int [][]count = new int[m][2];

        for(int i=0;i<m;i++)
        {
            count[i][0] = countSoldiers(mat[i]); //for i th row
            count[i][1] = i;
        }

        Arrays.sort(count , (a,b) ->{
          if(a[0]!=b[0])
          {
            return a[0]-b[0];
          }
          return a[1]-b[1];
        });

        int []res = new int[k];
        for(int i=0;i<k;i++)
        {
            res[i] = count[i][1];
        }
        return res;
    }
      
}