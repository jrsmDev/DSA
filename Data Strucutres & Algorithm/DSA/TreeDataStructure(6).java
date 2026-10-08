class Node {
    String data;     
    Node leftChild;
    Node rightChild;

    public Node(String key) {
        data = key;
        leftChild = rightChild = null;
    }
}

class TreeDataStructure6 {
    Node root = null;

    void traverse(Node node) {
        if (node != null) {
            traverse(node.leftChild);
            System.out.print(node.data + " ->");
            traverse(node.rightChild);
        }
    }

    double evaluate(Node node) {
        boolean isOperator = node.leftChild != null || node.rightChild != null;
        if (!isOperator) {
            return Double.parseDouble(node.data);
        }
        double left = evaluate(node.leftChild);
        double right = evaluate(node.rightChild);
        return switch (node.data) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> throw new IllegalArgumentException("Unknown operator: " + node.data);
        };
    }

    public static void main(String[] args) {
        TreeDataStructure6 tree = new TreeDataStructure6();

      
        tree.root = new Node("+");
        tree.root.leftChild = new Node("*");
        tree.root.leftChild.leftChild = new Node("+");
        tree.root.leftChild.leftChild.leftChild = new Node("6");
        tree.root.leftChild.leftChild.rightChild = new Node("4");
        tree.root.leftChild.rightChild = new Node("8");

    
        tree.root.rightChild = new Node("-");
        tree.root.rightChild.leftChild = new Node("9");
        tree.root.rightChild.rightChild = new Node("*");
        tree.root.rightChild.rightChild.leftChild = new Node("5");
        tree.root.rightChild.rightChild.rightChild = new Node("+");
        tree.root.rightChild.rightChild.rightChild.leftChild = new Node("2");
        tree.root.rightChild.rightChild.rightChild.rightChild = new Node("*");
        tree.root.rightChild.rightChild.rightChild.rightChild.leftChild = new Node("7");
        tree.root.rightChild.rightChild.rightChild.rightChild.rightChild = new Node("1");

        System.out.println("Inorder traversal: ");
        tree.traverse(tree.root);
        System.out.println();

        double result = tree.evaluate(tree.root);
        System.out.println("Result: " + result);
    }
}
