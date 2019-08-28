import java.util.Iterator;
import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;
    private int treeMaxHeight = 3; // Максимальная глубина дерева
    private boolean balance = true;

    @Override
    public boolean find(E value) {
        return doFind(value).current != null;
    }

    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);

        NodeAndParent nodeAndParent = doFind(value);
        Node<E> previous = nodeAndParent.parent;

        if (nodeAndParent.isEmpty()) {
            this.root = node;
            root.setHeight(1);
            return true;
        } else if (nodeAndParent.current != null) {
            return false;
        } else if (previous.shouldBeLeft(value)) {
            if (previous.getHeight() < treeMaxHeight){
                previous.setLeftChild(node);
            } else {
                System.out.println("Превышена максимальная глубина дерева");
            }
        } else {
            if (previous.getHeight() < treeMaxHeight){
                previous.setRightChild(node);
            } else {
                System.out.println("Превышена максимальная глубина дерева");
            }
        }

        size++;
        node.setHeight(previous.getHeight() + 1);
        return true;
    }

    private NodeAndParent doFind(E value) {
        if (isEmpty()) {
            return new NodeAndParent(null, null);
        }

        Node<E> parent = null;
        Node<E> current = this.root;
        do {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent);
            }

            parent = current;
            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        } while (current != null);

        return new NodeAndParent(null, parent);
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removedNode = nodeAndParent.current;

        if (removedNode == null) {
            return false;
        }
        else if (removedNode.isLeaf()) {
            removeLeafNode(parent, removedNode);
        }
        else if ( removedNode.hasOnlySingleChild() ) {//removedNode.L != null || removedNode.R != null
            removeNodeWithSingleChild(parent, removedNode);
        }
        else {
            removeCommonNode(parent, removedNode);
        }

        size--;
        return true;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(successor);
        }
        else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node<E> parent, Node<E> removedNode) {
        Node<E> childNode = removedNode.getLeftChild() != null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();

        if (removedNode == root) {
            root = childNode;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(childNode);
        }
        else {
            parent.setRightChild(childNode);
        }
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if (removedNode == root) {
            root = null;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(null);
        }
        else {
            parent.setRightChild(null);
        }
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
        System.out.println("Глубина дерева:" + height(root));
        System.out.println("Balanced:" + isBalanced(root));
    }

    @Override
    public boolean isBalanced(Node node) {
        if ( node != null )
        {
            if (!isBalancedNode(node)){
                balance = false;
            }
            isBalanced(node.getLeftChild());
            isBalanced((node.getRightChild()));
        }
        return balance;
    }

    public boolean isBalancedNode(Node node) {
        if (node.getLeftChild() == null || node.getRightChild() == null){
            if (node.getHeight() < ((height(root)) - 1)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mode: " + mode);
        }
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.println(current.getValue());
        inOrder(current.getRightChild());
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.println(current.getValue());
        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
        System.out.println(current.getValue());
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public Iterator<E> iterator() {

        return null;
//        return new Iterator<E>() {
//        Node<E> current = root;
//
//        @Override
//            public boolean hasNext() {
//                return current != null;
//            }
//
//            @Override
//            public E next() {
//                E value = current.getValue();
//                return value;
//            }
//        };
    }

    private class NodeAndParent {
        Node<E> current;
        Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }

        public boolean isEmpty() {
            return current == null && parent == null;
        }
    }

    public int height(Node node) {

        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}