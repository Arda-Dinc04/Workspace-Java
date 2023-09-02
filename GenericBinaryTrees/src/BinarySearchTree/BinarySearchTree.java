package BinarySearchTree;

public class BinarySearchTree<T extends Comparable> {
    Node<T> root;

    public void insertNode(T data) {
        root = insertNode(root, data);
    }

    @SuppressWarnings("unchecked")
    private Node<T> insertNode(Node<T> node, T data) {
        if (node == null)
            return new Node<T>(data);
        else if (node.data.compareTo(data) > 0) {
            node.leftNode = insertNode(node.leftNode, data);
        } else {
            node.rightNode = insertNode(node.rightNode, data);
        }
        return node;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> root) {
        if(root != null){
            inOrderTraversal(root.leftNode);
            System.out.print(root.data + " ");
            inOrderTraversal(root.rightNode);
        }
    }

    public void deleteNode(T data) {
        root = deleteNode(root, data);
    }

    private T inOrderSuccesor(Node<T> node){
        if(node.leftNode == null){
            return node.data;
        }
        return inOrderSuccesor(node.leftNode);
    }

    private Node<T> deleteNode(Node<T> node, T data) {
        if (node == null) {
            return null;
        } else if (node.data.compareTo(data) > 0) {
            node.leftNode = deleteNode(node.leftNode, data);
        } else if (node.data.compareTo(data) < 0) {
            node.rightNode = deleteNode(node.rightNode, data);
        }
        else{
            if(node.leftNode == null && node.rightNode == null){
                return null;
            }
            else if(node.leftNode != null && node.rightNode == null){
                return node.leftNode;
            }
            else if(node.leftNode == null && node.rightNode != null){
                return node.rightNode;
            }
            else{
                node.data = inOrderSuccesor(node.rightNode);
                node.rightNode = deleteNode(node.rightNode, node.data);
            }
        }
        return node;
    }

}
