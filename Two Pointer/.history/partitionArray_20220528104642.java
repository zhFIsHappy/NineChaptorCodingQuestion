//return partition index
public class partitionArray {
    public int partitionArray(int[] nums, int k){
        if(nums == null) return 0;
        int left = 0, right = nums.length -1;
        while(left<= right){
            while(left<=right && nums[left] < k){
                left++;
            }
            while(left <=right && nums[right]>= k){
                right --;
            }

            if(left <= right)
        }
    }
}
