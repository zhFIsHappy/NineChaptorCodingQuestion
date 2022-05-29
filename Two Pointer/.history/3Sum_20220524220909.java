public class 3Sum {
    public List<List<Integer>> threeSum (int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length ==0) return results;
        Array.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1, right = nums.length -1;
            int target = -nums[i];
            twoSum(nums,left,right,tagret,results);
        }
        return results;
    }
    private void twoSum(int[]nums, int left, int right, List<List<Intge>>)
}
