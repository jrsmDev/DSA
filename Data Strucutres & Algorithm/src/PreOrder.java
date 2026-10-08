public class PreOrder {
    static class Node {
        char data;
        Node leftChild;
        Node rightChild;

        Node(char data) {
            this.data = data;
        }
    }

    static void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.leftChild);
            preorderTraversal(node.rightChild);
        }
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.leftChild = new Node('B');
        root.rightChild = new Node('C');

        root.leftChild.leftChild = new Node('D');
        root.leftChild.rightChild = new Node('E');
        root.rightChild.rightChild = new Node('F');

        root.leftChild.leftChild.leftChild = new Node('G');
        root.leftChild.leftChild.rightChild = new Node('H');
        root.leftChild.rightChild.leftChild = new Node('I');
        root.rightChild.rightChild.leftChild = new Node('J');
        root.rightChild.rightChild.rightChild = new Node('K');

        root.leftChild.leftChild.rightChild.leftChild = new Node('L');
        root.leftChild.leftChild.rightChild.rightChild = new Node('M');
        root.rightChild.rightChild.leftChild.leftChild = new Node('N');
        root.rightChild.rightChild.rightChild.rightChild = new Node('O');

        System.out.print("Preorder traversal: ");
        preorderTraversal(root);
        System.out.println();
    }
}