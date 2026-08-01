class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high =n;
        int res = 0;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid]>nums[n-1]) // its the part 2
            {
                low = mid +1; // if the greater element is here then go towards the part 1 meaning the right part 
            }
            else
            {    //part 1
                res = mid;   // remember the value 
                high = mid -1;
            } 
        }
        
        return nums[res];
        
    }
}