
class Node {
    public int key;
    public Node leftChild;
    public Node rightChild;

    public int getKey() {
        return this.key;
    }

    public void setKey(final int key) {
        this.key = key;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }
}

class Tree {
    public static Node rootNode;

    public Tree() {
        rootNode = null;
    }

    public void add(int key) {
        Node newNode = new Node();
        newNode.setKey(key);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if (key == currentNode.getKey()) {
                    return;
                } else if (key < currentNode.getKey()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void printLeftToRight(Node localRoot) {
        if (localRoot != null) {
            printLeftToRight(localRoot.leftChild);
            System.out.print(localRoot.key + " ");
            printLeftToRight(localRoot.rightChild);
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(4);
        tree.add(7);
        tree.add(5);
        tree.add(9);
        tree.add(2);
        tree.add(6);
        tree.add(10);
        tree.add(1);
        tree.add(3);
        tree.add(8);

        tree.printLeftToRight(Tree.rootNode);
    }
}
