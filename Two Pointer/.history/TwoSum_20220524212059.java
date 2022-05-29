//TODO: Use HashMap to check whether exists
//TODO: Time Complexity O(N)
//ToDO: Space Complexity: O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[]{-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            if(map.containsKey(target- nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}
//TODO: Brute-Force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return new int[] { -1, -1 };
    }
}
