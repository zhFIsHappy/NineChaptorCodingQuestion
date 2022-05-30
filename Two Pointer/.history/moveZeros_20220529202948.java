public class moveZeros {
    public static void moveZeroes(int[] nums){
        int left =0, right =0;
        while(right < nums.length){
            if(nums[right] == 0){
                right ++;
            }else{
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right ++;
            }
        }
    }
}

[0,1,0,3,12]
 l