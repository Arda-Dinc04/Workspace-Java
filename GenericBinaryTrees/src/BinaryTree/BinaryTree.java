package BinaryTree;
public class BinaryTree<T extends Comparable> {
    Node<T> root;

    BinaryTree(){
        root = null;
    }

    public void inOrderTraversal(Node<T> node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node<T> node){
        if(node != null){
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);     
        }
    }

    public void postOrderTraversal(Node<T> node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);  
            System.out.print(node.data + " ");   
        }
    }
    
}
