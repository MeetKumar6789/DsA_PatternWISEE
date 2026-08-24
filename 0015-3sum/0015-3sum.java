 import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) 
        {
            // duplicate skipping
            if (i > 0 && nums[i] == nums[i - 1]) 
            {
                continue;
            }
            
            int j = i + 1;
            int k = n - 1;
            int sum = -nums[i]; // cause we want x + y such as it equals to -z
            
            while (j < k) {
                int s = nums[j] + nums[k];
                
                if (s == sum) {
                    Integer[] tri = {nums[i], nums[j], nums[k]};
                    result.add(Arrays.asList(tri));

                    j++;
                    k--;
                    
                    // skip the duplicates for the result here only
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    } // cause we wanna check 1 1{j} ^ ...
                    
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    } // cause we wanna check ...8(k) 8
                } else if (s < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
