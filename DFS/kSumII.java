public class Solution {
    /**
     * @param a: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     *          we will sort your return value in output
     */
    public List<List<Integer>> kSumII(int[] a, int k, int target) {
        // write your code here
        List<List<Integer>> subsets = new ArrayList<>();
        if(a == null || a.length == 0) return subsets;
        Arrays.sort(a);
        dfs(a,0,k,target,new ArrayList<Integer>(), subsets);
        return subsets;
    }

    private void dfs(int[] a, int index, int k, int target, List<Integer> subset, List<List<Integer>> subsets){
        if(k == 0 && target == 0){
            subsets.add(new ArrayList(subset));
            return;
        }
        if(k == 0 || target <= 0){
            return;
        }
        for(int i = index; i < a.length; i++){
            subset.add(a[i]);
            dfs(a,i+1, k-1, target - a[i], subset, subsets);
            subset.remove(subset.size()-1);
        }
    }
}