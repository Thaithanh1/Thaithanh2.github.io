/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 *
 * @author PhanThai
 */
public class P3 {
    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours;
        
        Node(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }
        public void addneighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }
        public List<Node> getNeighbours() {
            return neighbours;
        }
        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }
    // Recursive DFS
    public void dfs(Node node) {
        System.out.print(node.data + " ");
        List<Node> neighbours = node.getNeighbours();
        node.visited = true;
        for (int i = 0; i < neighbours.size(); i++) {
            Node n = neighbours.get(i);
            if(n != null && !n.visited) {
                dfs(n);
            }
        }
    }
    //Uing stack
    public void dfsUsingStack(Node node) {
        Stack<Node> stack=new Stack<Node>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            if (!element.visited) {
                System.out.print(element.data + " ");
                element.visited = true;
            }
            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if(n!=null && !n.visited) {
                    stack.add(n);
                }
            }
        }
    }
    public static void main(String arg[]) {
        Node node4 = new Node(4);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        
        node4.addneighbours(node1);
        node4.addneighbours(node2);
        node1.addneighbours(node3);
        node2.addneighbours(node1);
        node2.addneighbours(node3);
        node2.addneighbours(node6);
        node2.addneighbours(node5);
        node3.addneighbours(node6);
        node6.addneighbours(node7);
        node5.addneighbours(node7);
        
        P3 dfsExample = new P3();
        
        System.out.println("The DFS traversal of the gragh using stack");
        dfsExample.dfsUsingStack(node4);
        
        System.out.println();
        
        //Resetting the visited flag for nodes
        node4.visited = false;
        node1.visited = false;
        node2.visited = false;
        node3.visited = false;
        node6.visited = false;
        node5.visited = false;
        node7.visited = false;
        
        System.out.println("The DFS traversal of the graph using recursion");
        dfsExample.dfs(node4);
    }
   
}
