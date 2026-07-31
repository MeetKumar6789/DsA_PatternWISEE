 class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1, first = -1, last = -1;

        // pehla pass -> first occurrence dhundo
        low = 0; high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                first = mid; // yad rakho babua
                high = mid - 1; // left taraf aana pdega first occurance k liye
            }
        }

        // agar mila hi nahi to seedha -1,-1 bhej do
        if (first == -1) return new int[]{-1, -1};

        // dusra pass -> last occurrence dhundo
        low = 0; high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                last = mid; // yad rakho babua, ab dusri baar
                low = mid + 1; // right taraf aana pdega last occurance k liye
            }
        }

        return new int[]{first, last};
    }
}