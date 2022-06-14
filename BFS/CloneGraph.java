




/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// TODO: Time Complexity: O(N+M) N is #of nodes, M is # of edges
// TODO: Worst Case Senario: O(N^2)

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        List<Node> nodes = findNodesByBFS(node);
        Map<Node,Node> mapping = copyNode(nodes);
        copyEdges(nodes, mapping);
        return mapping.get(node);
    }
    
    private List<Node> findNodesByBFS(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            for(Node neighbor : curNode.neighbors){
                if(visited.contains(neighbor)){
                    continue;
                }
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
        return new LinkedList<>(visited);
    }
    
    private Map<Node, Node> copyNode(List<Node> nodes){
        Map<Node,Node> mapping = new HashMap<>();
        for(Node node : nodes){
            mapping.put(node, new Node(node.val));
        }
        return mapping;
    }
    
    private void copyEdges(List<Node> nodes, Map<Node, Node> mapping){
        for(Node node : nodes){ // 57 58 把copy 出来的 node 拿出来
            Node newNode = mapping.get(node);
            for(Node neighbor : node.neighbors){ // 旧的neighbor loop through
                Node newNeighbor = mapping.get(neighbor); // 对应的新neighbor 放到 newNeighbor中
                newNode.neighbors.add(newNeighbor); // 把新neighbor 给加到 新node 中
            }
        }
    }
}