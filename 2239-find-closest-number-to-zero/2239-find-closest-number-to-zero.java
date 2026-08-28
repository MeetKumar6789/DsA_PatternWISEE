class Solution {
    public int findClosestNumber(int[] nums) {
        int close = nums[0]; //initially taking 0th element as the closest to the zero:
        int MinDist = Math.abs(nums[0]);
      for(int i=1;i<nums.length;i++)
      {
        int dist = Math.abs(nums[i]);    //calculating and updating it:
        if( dist < MinDist ||dist==MinDist && nums[i]>close )
        {
            MinDist = dist;  //updating it cause mindist is more than dist
            close = nums[i]; //now updating the close cause new close is here
        }
      }
      return close;
    }
}