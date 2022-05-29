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
        return lastSmallerPointer;
    }
    private void swap(int[] nums, int lastSmallerPointer, int i) {
        int temp = nums[lastSmallerPointer];
        nums[lastSmallerPointer] = nums[i];
        nums[i] = temp;
    }
}

// 2 partitionArray template
// FIXME : Ex [2,0,2,1,1,0]
// lastSmallerPointer: 排序 pointer， pointer之前的是排序好的array
// example 跑完 partitionArray(nums, 1)
