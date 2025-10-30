public class BinarySearchTree {
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
    public void BinarySearchTree(){

    }

    public int height(Node node){
        if(node==null) return -1;
        return node.height;
    }
    public boolean isEmpty(Node node){
        return root==null;
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
        return node;
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
    public static void main(String[] args) {
        BinarySearchTree bt=new BinarySearchTree();
        int[] arr={5,60,55,4,3,89,99,12,682,153};
        bt.populate(arr);
        bt.display();
    }
}
