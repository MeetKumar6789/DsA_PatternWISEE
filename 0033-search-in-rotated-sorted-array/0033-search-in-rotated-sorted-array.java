 class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid; // base case

            if (nums[mid] > nums[n - 1]) {
                // mid is in the LEFT (unrotated, increasing) part
                if (nums[mid] < target) {
                    // target bigger than mid, must be right of mid
                    low = mid + 1;
                } else {
                    // target <= nums[mid]; is it still reachable in left part?
                    if (target > nums[n - 1]) {
                        // target still bigger than everything in right part -> stays left
                        high = mid - 1;
                    } else {
                        // target belongs to the right part
                        low = mid + 1;
                    }
                }
            } else {
                // mid is in the RIGHT (increasing) part
                if (nums[mid] > target) {
                    // target smaller than mid, must be left of mid
                    high = mid - 1;
                } else {
                    // target >= nums[mid]; is it still reachable in right part?
                    if (target > nums[n - 1]) {
                        // target too big for right part -> must be in left part
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}