class Solution {
 
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
     int n = profits.length;
     //making the 2d array of the capitals and profit 
     int[][] projects = new int[n][2];
     int i=0;
     for(i=0;i<n;i++)
     {
        projects[i][0] = capital[i];
        projects[i][1] = profits[i];
     }
     Arrays.sort(projects , (a,b) -> Integer.compare(a[0] ,b[0])); //ascending order sort 
     PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));//desc order Heap 

     //now k times iterate for max profit 
    int idx = 0;
     for(int x =0;x<k;x++)
     {
    while(idx<n && projects[idx][0]<=w)// adding all affordable projec's profit only
        {
            pq.add(projects[idx][1]);
            idx++;
        } 

        if(pq.isEmpty())
        {
            break;
        }

        w = w + pq.poll(); //adding max profit 
     }
      return w;
        
    }
}