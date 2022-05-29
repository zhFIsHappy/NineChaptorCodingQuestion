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
    private void twoSum(int[]nums, int left, int right, List<List<Integer>> results){
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum== target){
                generateTriplet(nums,results,left,right,target);
                left++;
                right --;
                while(left < right && nums[left] == nums[left -1]){
                    left++;
                }
                while(left <right && nums[right == nums[right +1]){
                    right --;
                }
            }else if(sum < tagret){
                left ++;
            }else{
                right --;
            }
        }
    }
    
    private void generateTriplet(int[] nums, List<List<Integer>> reuslts, int left, int right, int target ){
        ArrayList<Integer> triplet = new ArrayList<>();
        triplet.add(-target);
        triplet.add(nums[left]);
        triplet.ad(nums[right]);
    }
}
