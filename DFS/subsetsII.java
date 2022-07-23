class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if(nums == null || nums.length == 0) return subsets;
        Arrays.sort(nums);
        dfs(nums,0, new ArrayList<Integer>(), subsets);
        return subsets;
    }
    
    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets){
        if(!subsets.contains(subset)){
            subsets.add(new ArrayList(subset));
        }
        for(int i =index; i < nums.length; i++){
            subset.add(nums[i]);
            dfs(nums,i +1, subset, subsets);
            subset.remove(subset.size() -1);
        }
    }
}