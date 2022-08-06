class Solution{
    public boolean isValidBST(TreeNode root){
        return helper(root, null , null);
    }
    private boolean helper(TreeNode root, Integer left, Integer right){
        if(root == null){ // 检查完了/本身就是null 返回true
            return true;
        }
        if((left!= null && root.val <= left) || (right!=null && root.val >= right)){ //不满足bst的feature 返回false
            return false;
        }
        return helper(root.left, left, root.val) && helper(root.right, root.val, right); // set bounds
    }
}