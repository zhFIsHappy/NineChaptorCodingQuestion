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
// ToDO: Time Complexity: O(N+M) N is #of nodes, M is # of edges
// TODO: Worst Case Senario: O(N^2)
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        List<Node> nodes = findNodesByBFS(node); // Use BFS find every node
        Map<Node, Node> mapping = copyNodes(nodes); // 
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
                queue.offer(neighbor);
            }
        }
        return new LinkedList<>(visited);
    }
    
    private Map<Node, Node> copyNodes(List<Node> nodes){
        Map<Node, Node> mapping = new HashMap<>();
        for(Node node: nodes ){
            mapping.put(node,new Node(node.val));
        }
        return mapping;
    }
    
    private void copyEdges(List<Node> nodes, Map<Node, Node> mapping){
        for(Node node : nodes){ // loop through List of Node
            Node newNode = mapping.get(node); // pull out A' B' C' D'
            for(Node neighbor :node.neighbors){ //loop through old neighbors 
                Node newNeighbor = mapping.get(neighbor); // get old neighbors'edges
                newNode.neighbors.add(newNeighbor); // add edges to new nodes's neighbors
            }
        } 
    } 
}

