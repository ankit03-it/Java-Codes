// Q5: Binary tree level order traversal.


import java.util.*;
public class BinaryTreeLevelOrderTraversal {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = null; right = null;
        }
    }
    static class BinaryTree{
        // create binary tree ftom preorder 
        static int idx = -1;
        public static Node create(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = create(nodes);
            newNode.right = create(nodes);
            return newNode;
        }
        public static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> level = new ArrayList<>();
                for(int i=0;i<size;i++){
                    Node current = q.remove();
                    level.add(current.data);
                    if(current.left != null) q.add(current.left);
                    if(current.right != null) q.add(current.right);
                }
                result.add(level);
            }
            System.out.println(result);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {3,9,-1,-1,20,15,-1,-1,7,-1,-1}; //preorder arr
        Node root = BinaryTree.create(nodes);
        System.out.println(root.data);
        BinaryTree.levelOrder(root);
    }
}
