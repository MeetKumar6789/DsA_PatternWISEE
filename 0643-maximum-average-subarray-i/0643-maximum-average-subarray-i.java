  class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first 'k' elements
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        double maxSum = currentSum;
        
        // Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            // Add the next element and remove the first element of the previous window
            currentSum += nums[i] - nums[i - k];
            // Track the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Return the maximum average
        return maxSum / k;
    }
}
