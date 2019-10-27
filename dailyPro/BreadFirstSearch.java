import java.util.ArrayList;
import java.util.*;
class Program {
  // Do not edit the class below except
  // for the breadthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    ArrayList<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public ArrayList<String> breadthFirstSearch(ArrayList<String> array) {
      // Write your code here.
			   
			   Deque<Node> nodes = new ArrayDeque<>();
			   array.add(this.name);
			   for(Node node: children){
					  System.out.println(node.name);
					  nodes.add(node);
				 }
			   while(nodes.size() > 0){
					  Node temp = nodes.poll();
					  array.add(temp.name);
					  for(Node node: temp.children){
					 	  System.out.println(node.name);
					    nodes.add(node);
					  }
				 }
			   System.out.println(String.valueOf(array));
			   return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
