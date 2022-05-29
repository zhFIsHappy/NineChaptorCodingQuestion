
//TODO: Time Complexity O(0)

public class TwoSumIII {
    public List<Integer> nums;
    public TwoSum(){
        nums = new ArrayList<Integer>();
    }
    
    // TOdo: Adding while sorting the array
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
        nums.set(index -1, temp);
    }  
    //TODO: Use two pointers to check whether we can find 
    public boolean find(int targetValue){
        int left = 0, right = nums.size()-1;
        while(left < right){
            int twoSum = nums.get(left) + nums(right);
            if(twoSum < targetValue){
                left ++;
            }
            else if(twoSum > targetValue){
                right --;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
