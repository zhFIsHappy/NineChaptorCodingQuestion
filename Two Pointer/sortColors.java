public class sortColors { 
    public void sortColors(int[] nums){
        partitionArray(nums,1); // 每一次都会跑完所有的array 并且按照 把 比1小的放在lastSmallerPointer左边， 大的在右边
        partitionArray(nums,2);
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
// [2,0,2,1,1,0], example input
// example 跑完 partitionArray(nums, 1);
// [0,2,2,1,1,0]
// [0,0,2,1,1,2]





public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        partitionArray(nums, 1);
        partitionArray(nums, 2);
    }
    public int partitionArray(int[] nums, int k){
        if(nums == null || nums.length == 0) return -1;
        int left = 0 , right = nums.length -1;
        while(left <= right){
            while(left <= right && nums[left] < k){
                left ++;
            }
            while(left <= right && nums[right] >= k){
                right --;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left ++;
                right --;
            }
        }
        return left;
    }
}