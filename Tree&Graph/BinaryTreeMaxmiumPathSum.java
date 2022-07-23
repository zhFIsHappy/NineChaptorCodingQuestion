class BinaryTreeMaxmiumPathSum {
    int maxValue = Integer.MIN_VALUE;
    public int max_gain(TreeNode root) {
        // if root == null, then we have value of zero
        if(root== null){
            return 0;
        }
        // get the left/right child value, Math.max-> compare with 0 to eliminate negative case that not supposed to be added
        int left = Math.max(max_gain(root.left),0); 
        int right = Math.max(max_gain(root.right),0);
        // calculate the current path sum
        int curValue = left + right + root.val;
        // update the maxValue
        maxValue = Math.max(maxValue, curValue);
        // get into the next level, cna only compute one branch but not two,specific complain is on the image attached
        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root){
        max_gain(root);
        return maxValue;
    }
}