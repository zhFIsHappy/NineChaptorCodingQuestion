public class sortColors { 
    public void sortColors(int[] nums){
        partitionArray(nums,1);
        partitionArray(nums, 2);
    }
    public int partitionArray(int[] nums, int k){
        int lastSmallerPointer =-1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < k){
                lastSmallerPointer ++;
                swap(nums,lastSmallerPointer, i);
            }
        }
    }
    private void swap(int[] nums, int lastSmallerPointer, int i) {
        int temp = nums[lastSmaller]
    }
}
