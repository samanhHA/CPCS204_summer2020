

public class Tree {

    private Node root;

    //Constructor
    public Tree() {
        root = null;
    }

    // a method to return true if the tree has no nodes 
    public boolean isEmpty() {
        return root == null;
    }

    public boolean search(int data) {
        return search(root, data);

    }

    private boolean search(Node n, int data) {
        if (n == null) {
            return false;
        } else {
            //The data is found in n node 
            if (data == n.getData()) {
                return true;
            } //The data is not found so it will recursively search in other nodes
            else if (data < n.getData()) {
                return search(n.getLeft(), data);
            } else {
                return search(n.getRight(), data);
            }
        }
    }

    public void insert(int data) {
        Node n = new Node(data);
        root = insert(root, n);
    }

    private Node insert(Node p, Node newNode) {
        //there is no tree
        if (p == null) {
            return newNode;
        } //there is a tree 
        else {
            if (newNode.getData() > p.getData()) {
                //insert in the right subtree 
                Node temp = insert(p.getRight(), newNode);
                p.setRight(temp);

            } else {
                //insert in the left subtree
                Node temp = insert(p.getLeft(), newNode);
                p.setLeft(temp);
            }
        }
        return p;

    }

    public int sumNodes() {
        return sumNodes(root);
    }

    private int sumNodes(Node p) {
        if (p != null) {
            return p.getData() + sumNodes(p.getLeft()) + sumNodes(p.getRight());
        } else {
            return 0;
        }
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    public Node findNode(int data) {
        return findNode(root, data);
    }

    private Node findNode(Node p, int data) {
        if (p == null) {
            return null;
        } else {
            if (data == p.getData()) // data found in p
            {
                return p;
            } else if (data < p.getData()) {
                return findNode(p.getLeft(), data);
            } else {
                return findNode(p.getRight(), data);
            }
        }
    }

    public Node parent(Node p) {
        return parent(root, p);
    }

    private Node parent(Node root, Node p) {
        if (root == null || root == p) // no parent
        {
            return null;
        }
        if (root.getLeft() == p || root.getRight() == p) //root is the parent
        {
            return root;
        }
        if (p.getData() < root.getData()) {
            return parent(root.getLeft(), p);
        } else if (p.getData() > root.getData()) {
            return parent(root.getRight(), p);
        } else {
            return null;
        }
    }

    public boolean isLeaf(Node p) {
        return (p.getLeft() == null && p.getRight() == null);
    }

    public boolean hasOnlyLeftChild(Node p) {
        return (p.getLeft() != null && p.getRight() == null);
    }

    public boolean hasOnlyRightChild(Node p) {
        return (p.getLeft() == null && p.getRight() != null);

    }

    public Node minNode(Node root) {
        if (root == null) {
            return null;
        } else {
            if (root.getLeft() == null) {
                return root;
            } else {
                return minNode(root.getLeft());
            }
        }
    }

    public Node maxNode(Node root) {
        if (root == null) {
            return null;
        } else {
            if (root.getRight() == null) {
                return root;
            } else {
                return maxNode(root.getRight());
            }
        }
    }

    private Node delete(Node p, int data) {
        Node node2delete, newnode2delete, node2save, parent;
        int saveValue;

        //find node to be deleted
        node2delete = findNode(p, data);
        //node to be deleted is not found
        if (node2delete == null) {
            return root;
        }

        //find the parent
        parent = parent(p, node2delete);

        //if node2delete is a leaf node
        if (isLeaf(node2delete)) {

            if (parent == null) {
                return null; // the node2delete is the only node in the tree
            }
            // this if statment is to delete node if it is a left or right child
            if (data < parent.getData()) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

            return p; //return the root if it got updated
        }

        //if node2delete has only a left child
        if (hasOnlyLeftChild(node2delete)) {

            if (parent == null) //node2delete is the root
            {
                return node2delete.getLeft();
            }

            // Search to locate the node wether it's in the right or the left of other nodes
            if (data < parent.getData()) {
                parent.setLeft(parent.getLeft().getLeft());
            } else {
                parent.setRight(parent.getRight().getLeft());
            }

            return p;//return the root if it got updated
        }

        //if node2delete has only a right child
        if (hasOnlyRightChild(node2delete)) {

            if (parent == null) //node2delete is the root
            {
                return node2delete.getRight();
            }

            // Search to locate the node whether it's in the right or the left of other nodes
            if (data < parent.getData()) {
                parent.setLeft(parent.getLeft().getRight());
            } else {
                parent.setRight(parent.getRight().getRight());
            }

            return p;  //return the root if it got updated
        }

        //node2delete has TWO children.
        //find the minVal from the right subtree.
        newnode2delete = minNode(node2delete.getRight());
        //save the data from this node temporarily
        saveValue = newnode2delete.getData();

        p = delete(p, saveValue); //delete the saveValue by calling delete method recursively

        node2delete.setData(saveValue); //set the saveValue in its correct place

        return p;  //return the root if it got updated

    }

    public void clear() {
        root.left = null;
        root.right = null;
        root = null;
    }

}
