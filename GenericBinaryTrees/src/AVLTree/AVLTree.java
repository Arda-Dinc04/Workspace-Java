package AVLTree;

public class AVLTree<T extends Comparable> {
    Node<T> root;

    public Node<T> leftRotate(Node<T> y) {
        Node<T> x = y.rightNode;
        Node<T> B = y.leftNode;

        y.leftNode = x;
        x.rightNode = B;
        x.height = Math.max(x.leftNode.height, x.rightNode.height) + 1;
        y.height = Math.max(y.leftNode.height, y.rightNode.height) + 1;
        return y;
    }

    public Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.leftNode;
        Node<T> B = x.rightNode;

        y.leftNode = B;
        x.rightNode = y;

        x.height = Math.max(x.leftNode.height, x.rightNode.height) + 1;
        y.height = Math.max(y.leftNode.height, y.rightNode.height) + 1;
        return x;
    }

    public void insertNode(T data) {
        root = insertNodePrivate(root, data);
    }

    @SuppressWarnings ("unchecked")
    private Node<T> insertNodePrivate(Node<T> node, T data) {
        if (node == null) {
            return new Node<T>(data);
        } else if (node.data.compareTo(data) < 0) {
            node.rightNode = insertNodePrivate(node.rightNode, data);
        } else if (node.data.compareTo(data) > 0) {
            node.leftNode = insertNodePrivate(node.leftNode, data);
        } else {
            return node;
        }

        node.height = Math.max(getHeight(node.leftNode),getHeight(node.rightNode)) + 1;
        int balanceFactor = getBalance(node);

        if (balanceFactor > 1) {
            if (data.compareTo(node.leftNode.data) < 0) {
                return rightRotate(node);
            } else {
                node.leftNode = leftRotate(node.leftNode);
                return rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (data.compareTo(node.rightNode.data) > 0) {
                return leftRotate(node);
            } else {
                node.rightNode = rightRotate(node.rightNode);
                return leftRotate(node);
            }
        }
        return node;
    }

    public void deleteNode(T data) {
        root = deleteNode(root, data);
    }

    private Node<T> deleteNode(Node<T> node, T data){
        if(node == null)
            return node;
        if(node.data.compareTo(data) < 0){
            node.leftNode = deleteNode(node.leftNode, data);
        }
        else if (node.data.compareTo(data) > 0) {
            node.rightNode = deleteNode(node.rightNode, data);
        }
        else {
            if (node.rightNode == null && node.leftNode == null) {
                return null;
            }
            else if(node.rightNode != null && node.leftNode == null){
                return node.rightNode;
            }
            else if (node.rightNode == null && node.leftNode != null)
                return node.leftNode;
            else{
                node.data = inOrderSuccesor(node.rightNode);
                node.rightNode = deleteNode(node.rightNode, node.data);
            }
        }

        node.height = Math.max(getHeight(node.leftNode),getHeight(node.rightNode)) + 1;
        int balanceFactor = getBalance(node);

        if(balanceFactor > 1){
            if(getBalance(node.leftNode) >= 0){
                return rightRotate(node);
            }
            else{
                node.leftNode = leftRotate(node.leftNode);
                return rightRotate(node);
            }
        }
        else if(balanceFactor < -1){
            if(getBalance(node.rightNode) <= 0)
                return leftRotate(node);
            else{
                node.rightNode = rightRotate(node.rightNode);
                return leftRotate(node);
            }
        }
    
        return node;
    }

    public int getBalance(Node<T> node){
        if(node == null)
            return 0;
        return getHeight(node.leftNode) - getHeight(node.rightNode);
    }

    public int getHeight(Node<T> node){
        if(node == null)
            return 0;
        return node.height;
    }

    public T inOrderSuccesor(Node<T> node){
        if(node.leftNode == null)
            return node.data;
        return inOrderSuccesor(node.leftNode);
    }

}
