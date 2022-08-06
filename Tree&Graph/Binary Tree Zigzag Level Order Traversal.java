class Solution{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean left2right = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            for(int i =0; i < size; i++){ //这个for loop里面的东西是这一层要做的事情，在这里要做的事情是check是加left还是加right node val 进入list 
                TreeNode curNode = queue.poll();
                if(left2right){
                    level.add(curNode.val);
                }else{
                    level.add(0,curNode.val);
                }
                if(curNode.left!= null) queue.offer(curNode.left);
                if(curNode.right!=null) queue.offer(curNode.right);
            }
            left2right = !left2right; // 下一层的时候就是反过来的
            res.add(level); // 把这一层的val 加入 res
        }
        return res;
    }
}