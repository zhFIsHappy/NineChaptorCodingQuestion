class BinaryTreeMaxmiumPathSum {
    int maxValue = Integer.MIN_VALUE;
    public maxSum (TreeNode root){
        helper(root);
        return maxValue;
    }

    private int helper(TreeNode root){
        if(node == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxValue = Math.max(maxValue, node.val + left + right);//横向， 全局的 拱形
        return Math.max(left, right) + node.val; // 返回左右孩子中最大的那个 加上 本身node val， 纵向最大值
    }
    
}