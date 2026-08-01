class Solution {
    public int peakIndexInMountainArray(int[] arr) {
         int low = 0;
         int high = arr.length-1;
         int res = -1;
         while(high>=low)
         {
            int mid = low + (high - low)/2;
            if(arr[mid]<arr[mid+1])
            {
                low = 1+mid; // chadai ka case babu  
            }
            else
            {
                res = mid; //we wanna find the firsst occurance of the peak soooo
                high = mid -1;
            }
         }
        return res;
    }
}