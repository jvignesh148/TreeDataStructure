public class AVLTree {
    public class Node {
        int val;
        int height;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        public int getValue() {
            return val;
        }
    }
    private Node root;
    public AVLTree(){

    }
    public int height() {
        return height(root);
    }
    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value){
        root=insert(value, root);
    }
    private Node insert(int value, Node node){
        if(node==null) {
            node=new Node(value);
            return node;
        }
        if(value<node.val){
            node.left=insert(value,node.left);
        }
        if(value>node.val){
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right)) +1;
        return rotate(node);
    }
    private Node rotate(Node node){
        int balance=height(node.left)-height(node.right);
        if( balance> 1){
            // Left Heavy
            Node leftChild=node.left;
            if(leftChild!=null && height(leftChild.left) >= height(leftChild.right)) return rightRotate(node);   //  --- Left-Left case
            else {
                node.left = leftRotate(leftChild);

                return rightRotate(node);   //  --- Left-Right case
            }
        }
        if(balance< -1 ){
            // Left Heavy
            Node rightChild=node.right;
            if(rightChild!=null && height(rightChild.left) >= height(rightChild.right)) return leftRotate(node);   //  --- Right-Right case
            else {
                node.right = leftRotate(rightChild);

                return leftRotate(node);   //  --- Left-Right case
            }
        }
        return node;
    }

    public Node rightRotate(Node p){
        if (p == null || p.left == null) return p;
        Node c=p.left,t=c.right;
        c.right=p;
        p.left=t;
        p.height=Math.max(height(p.left),height(p.right)) + 1;
        c.height=Math.max(height(c.left),height(c.right)) + 1;
        return c;
    }

    public Node leftRotate(Node p){
        if (p == null || p.right == null) return p;
        Node c=p.right,t=c.left;
        c.left=p;
        p.right=t;
        p.height=Math.max(height(p.left),height(p.right)) + 1;
        c.height=Math.max(height(c.left),height(c.right)) + 1;
        return c;
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if(node==null) return true;
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.right) && balanced(node.left);
    }

    public void populate(int[] nums){
        for(int i : nums) this.insert(i);
    }
    public void populatedSorted(int[] nums){
        populatesSorted(nums,0,nums.length);
    }
    private void populatesSorted(int[] nums,int start,int end){
        if(start>=end) return;
        int mid=(start+end)/2;
        this.insert(nums[mid]);
        populatesSorted(nums,start,mid);
        populatesSorted(nums,mid+1,end);
    }
    public void display(){
        display(this.root,"Root Node: ");
    }
    public void display(Node node, String details){
        if(node==null) return;
        System.out.println(details+ node.val);
        display(node.left,"Left child of " + node.val + " : ");
        display(node.right,"right child of " + node.val + " : ");

    }
    public int heightTree1(){
        return heightTree(root);
    }
    public int heightTree(Node node){
        if(node==null) return -1;
        int leftHeight=heightTree(node.left);
        int rightHeight=heightTree(node.right);
        return 1+ Math.max(leftHeight,rightHeight);
    }
    public static void main(String[] args) {
        AVLTree bt=new AVLTree();
        int[] sorted=new int[1000];
        for(int i=0;i<1000;i++) sorted[i]=i;
        bt.populatedSorted(sorted);  // recursively inserts middle first
        System.out.println("Height = " + bt.height());
        System.out.println("Height of the tree = " + bt.heightTree1());
//        for(int i=1;i<=1000;i++) bt.insert(i);
//        bt.display();
//        System.out.print(bt.height(bt.root));
    }
}
