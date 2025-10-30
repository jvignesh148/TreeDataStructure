import java.util.*;

public class BinaryTree {

    public BinaryTree(){
        
    }
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root node");
        int value=scanner.nextInt();
        root=new Node(value);
        populate(scanner,root);
    }

    private void populate(Scanner scanner,Node node){
        System.out.println("Do you want to enter left of "+ node.val);
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of "+ node.val);
            int value=scanner.nextInt();
            node.left=new Node(value);
            populate(scanner,node.left);
        }

        System.out.println("Do you want to enter right of "+ node.val);
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of "+ node.val);
            int val=scanner.nextInt();
            node.right=new Node(val);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(root," ");
    }
    private void display(Node node, String indent){
        if(node==null) return;
        System.out.println(indent + node.val);
        display(node.left , indent+"\t");
        display(node.right , indent+"\t");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BinaryTree tree=new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }
}
