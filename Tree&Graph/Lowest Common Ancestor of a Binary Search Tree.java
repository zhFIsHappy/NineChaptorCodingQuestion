class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return root;
        }
        if(root == p ||root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if(left != null){ // 在在遍历的时候找到了一个p或者一个q 左右才有可能不为空  
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }
}