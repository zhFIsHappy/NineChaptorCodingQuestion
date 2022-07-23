class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        // 如果数据不合理就 graph就会是null
        if(graph == null){
            return "";
        }
        return topologicalSorting(graph);
        
    }
    
    private Map<Character, Set<Character>> constructGraph(String[] words){
        // store character -> 多个字母 关系
        // value中的值比 key 大
        Map<Character,Set<Character>> graph = new HashMap<>();
        // 生成所有的点， 每个点的后续点为空
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j< words[i].length(); j++){
                char c = words[i].charAt(j);
                if(!graph.containsKey(c)){
                    graph.put(c,new HashSet<Character>());
                }
            }
        }
        // 生成所有的边， 找到一个点之后的点，并且建立连接
        for(int i =0; i< words.length-1; i++){
            int index = 0;
            while(index < words[i].length() && index < words[i+1].length()){
                if(words[i].charAt(index) != words[i+1].charAt(index)){
                    graph.get(words[i].charAt(index)).add(words[i+1].charAt(index)); // 把不一样的character加到 word 1的 set中
                    break;
                }
                index ++;
            }
            //如果输入为["abc","ab"] 不合法， 返回null
            if(index == Math.min(words[i].length(), words[i+1].length())){
                if(words[i].length() > words[i+1].length()){
                    return null;
                }
            }
        }
        return graph;
    }
    
    private String topologicalSorting(Map<Character, Set<Character>> graph){
        //统计每个点的入度
        Map<Character, Integer> indegree = getIndegree(graph);
        //这里可以有多个有效的字母序，返回正常字典看起来最小的，所以是priority queue
        Queue<Character> queue = new PriorityQueue<>();
        //把每个入读为 0的点放入 queue 中 作为起始点
        for(Character c : indegree.keySet()){
            if(indegree.get(c) == 0){
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        // 每次拿出queue的一个点， 去掉这个点的连边，与这个点相邻的点的indegree -1
        while(!queue.isEmpty()){
            Character head = queue.poll();
            sb.append(head);
            for(Character neighbor : graph.get(head)){
                indegree.put(neighbor, indegree.get(neighbor) -1);
                if(indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }
        //如果有些字母没有出现在 字典排序中，就没有答案
        return (sb.length() == indegree.size()) ? sb.toString() : "";
    }
    
    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph){
        Map<Character, Integer> indegree = new HashMap<>();
        //初始化 所有的点入度为0
        for(Character u : graph.keySet()){
            indegree.put(u,0);
        }
        // 所有邻居的入度 +1 
        for(Character u : graph.keySet()){
            for(Character v : graph.get(u)){
                indegree.put(v,indegree.get(v) +1);
            }
        }
        return indegree;
    }
}
