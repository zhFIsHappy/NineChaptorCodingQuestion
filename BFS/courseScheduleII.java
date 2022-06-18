public class courseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        // get indegree for each course 
        //[[1,0],[2,0],[3,1],[3,2]]
        // indegree [0,1,1,2]
        for(int[] pre : prerequisites){
            indegree[pre[0]] ++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // 如果入度是0的话 放入queue
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        int i = 0;
        // 每次拿一个node 出来， 并且-- 与他连接的node，如果等于0， 加进queue
        while(!queue.isEmpty()){
            Integer curr = queue.poll(); // curr 是现在上课上到的最新的进度
            res[i++] = curr;
            
            for(int[] pre : prerequisites){
                if(pre[1] == curr){
                    indegree[pre[0]] --;
                    if(indegree[pre[0]] == 0){
                        queue.offer(pre[0]);
                    }
                }
            }
        }
        return i == numCourses ? res: new int[]{}; 
        
    }
}
