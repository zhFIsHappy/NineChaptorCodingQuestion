public class 3Sum {
    public List<List<Integer>> threeSum (int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length ==0) return results;
        Array.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = nums[i+1], right = nums
        }
    }
}