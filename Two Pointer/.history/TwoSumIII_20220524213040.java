public class TwoSumIII {
    public List<Integer> nums;
    public TwoSum(){
        nums = new ArrayList<Integer>();
    }

    public void add(int number){
        nums.add(number);
        int index= nums.size()-1;
        while(index > 0 && nums.get(index-1) > nums.get(index)){
            swap(nums,index);
            index --;
        }
    }

    private void swap(List<Integer> nums, int index){
        int temp = nums.get(index);
        nums.set(index, nums.get(index-1));
        nums.set
    }
}
