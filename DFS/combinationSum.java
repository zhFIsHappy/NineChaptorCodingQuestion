public class Solution{
    public List<List<String>> combinationSum(int[] candidates, int target){
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return results;
        }

        int[] uniqueSortedNumbers = removeDuplicates(candidates);
        dfs(uniqueSortedNumbers, 0 , new ArrayList<>(), target, results);
        return results;
    }

    private int[] removeDuplicatesAndSort(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int[] uniqueSortedNumbers = new int[set.size()];
        int i =0;
        for(int num: set){
            uniqueSortedNumbers[i++] = num;
        }
        Arrays.sort(uniqueSortedNumbers);
        return uniqueSortedNumbers;
    }

    private void dfs(int[] nums, int index, List<Integer> current, int remainingTarget, List<List<Integer>> results){
        if(remainingTarget == 0){
            results.add(new ArrayList<>(current));
            return ;
        }

        for(int i = index, i < nums.length; i++){
            if(remainingTarget <= nums[i]){
                return;
            }

            current.add(nums[i]);
            dfs(nums, i , current, remainingTarget -nums[i], results);
            current.remove(current.size()-1);
        }
    }
}