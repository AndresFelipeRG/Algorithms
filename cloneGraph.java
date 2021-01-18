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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Node, Node> cloneMap = new HashMap<>();
        cloneMap.put(node, new Node(node.val));
        while(!queue.isEmpty()){
            Node currNode = queue.remove();
            for(Node neighbor: currNode.neighbors){
                if(!cloneMap.containsKey(neighbor)){
                    Node newNode = new Node(neighbor.val);
                    cloneMap.put(neighbor, newNode);
                    queue.add(neighbor);
                }
                cloneMap.get(currNode).neighbors.add(cloneMap.get(neighbor));
            }
        }
        return cloneMap.get(node);
    }
}
