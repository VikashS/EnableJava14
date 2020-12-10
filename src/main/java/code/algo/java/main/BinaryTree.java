package code.algo.java.main;

public class BinaryTree {
    Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(1);
        tree.root.right = new Node(4);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(5);
        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.print_tree();
        System.out.println("");

        /// now inverting
        tree.invert();


        System.out.println("After Invert is :");
        tree.print_tree();
        System.out.println("");

    }
    void print_tree()
    {
        print_tree(root);
    }

    // print InOrder binary tree traversal.
    void print_tree(Node node)
    {
        if (node == null)
            return;
        print_tree(node.left);
        System.out.print(node.data + " ");

        print_tree(node.right);
    }

    private void invert() {
        root=invert(root);
    }

    Node invert(Node node){
        if(node==null) return node;
        Node left= invert(node.left);
        Node right= invert(node.right);
        node.right=left;
        node.left=right;
        return node;
    }


}
