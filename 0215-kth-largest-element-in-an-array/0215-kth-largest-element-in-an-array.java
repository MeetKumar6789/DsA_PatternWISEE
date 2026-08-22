class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int n = nums.length;
        int i=0;
        for(i=0;i<k;i++)
        {
            pq.add(nums[i]);
        }
        for(i=k;i<n;i++)
        {
            if(nums[i]<=pq.peek())
            {
             continue;
            }
            else
            {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}