class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int low = 0 , high = n-1;
        int leftMost = 0 ,rightMost = 0 , water = 0;

        while(low<=high)
        {
            if(height[low]<=height[high])
            { 
                if(height[low]>leftMost)
                {
                    leftMost = height[low];
                }
                else
                {
                    water+=leftMost - height[low];
                }
           low++;
            }
            else
            {
                if(height[high]>rightMost)
                {
                    rightMost = height[high];
                }
                else
                {
                    water+=rightMost - height[high];
                }
                high--;
            }
        }

      return water;
    }
}