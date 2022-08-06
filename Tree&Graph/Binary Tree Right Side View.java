class Solution{
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i< size; i++){
                TreeNode curNode = queue.poll();
                if(i == 0){ // 保证每次加进去的是right node val
                    res.add(curNode.val);
                }
                if(curNode.right!= null){ // 先加right进来 这样我们只需要加第一个就好
                    queue.offer(curNode.right);
                }
                if(curNode.left!= null){
                    queue.offer(curNode.left);
                }
            }
        }
        return res;
    }
}