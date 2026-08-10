 class Solution {
    public int maximumCandies(int[] candies, long k) {
        int lo = 1, hi = 0;
        for (int c : candies) hi = Math.max(hi, c);
        
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canAllocate(candies, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canAllocate(int[] candies, long k, int guess) {
        long count = 0;
        for (int c : candies) {
            count += c / guess;
            if (count >= k) return true; // early exit to avoid overflow/slow loops
        }
        return count >= k;
    }
}