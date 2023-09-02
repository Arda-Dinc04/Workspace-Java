package BalancedTree;

public class BalanceTree<T extends Comparable> {
    protected Node<T> root;

    public boolean checkBalance(Node<T> node, Height height) {
        if (node == null) {
            height.height = 0;
            return true;
        }
        Height LH = new Height();
        Height RH = new Height();

        boolean isLeftBalanced = checkBalance(node.leftNode, LH);
        boolean isRightBalanced = checkBalance(node.rigNode, RH);

        height.height = Math.max(LH.height, RH.height)+1;

        if(Math.abs(LH.height-RH.height) >1){
            return false;
        }
        else{
            return isLeftBalanced && isRightBalanced;
        }
    }

}
