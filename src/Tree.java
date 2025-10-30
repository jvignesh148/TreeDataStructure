import java.util.*;

public class Tree {
    Node root;
    public void insert(int val){
        root=insertRec(root,val);
    }
    public Node insertRec(Node root,int val){
        if(root==null){
            root=new Node(val);
        }
        else if(val<root.val){
            root.left=insertRec(root.left,val);
        }
        else if(val>root.val){
            root.right=insertRec(root.right,val);
        }
        return root;
    }
    public void inorder(){
        inOrder(root);
    }
    public void inOrder(Node node){
        if(root==null) return;
        if(root!=null){
            if(node.left!=null) inOrder(node.left);
            System.out.print(node.val+" ");
            if(node.right!=null)inOrder(node.right);
        }
    }
    public void level(){
        levelOrder(root);
    }
    public void levelOrder(Node node){
        if(node==null) return;
        Queue<Node> qe=new LinkedList<>();
        qe.add(node);
        while(!qe.isEmpty()) {
            Node temp = qe.poll();
            System.out.print(temp.val + " ");
            if (node.left != null) qe.add(node.left);
            if (node.right != null) qe.add(node.right);
        }
    }
}
class Node{
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
}
