package NineChaptorCodingQuestion.Binary Search;

public class SearchInRotatedArray {
    public int search(int[] nums, int target){
        if(nums == null || nums.length ==0) return -1;
        int start =0, end = nums.length -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){
                if(target >= nums[start] && target < nums[mid]) end = mid;
                else start = mid;
            }else{
                if(target >= nums[mid] && target < nums[end]) start = mid;
                else end = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}



// 这里是double check
// 1. check mid 左边是否是rotated的， 是的话就查从 start -> mid 是否有target， 有的话 就定位在start ->mid, 没有的话就 定位到 mid -> end
// 2. regular check， 如果左边不是rotated的