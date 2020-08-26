package com.txwdd.datastructure.tree;

/**
 *
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
        Node root = new Node(4);
        Node node1 = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node5;

        AVLTree avlTree = new AVLTree();
        avlTree.setRoot(root);
        int leftHeight = avlTree.leftHeight();
        System.out.println("left height===" + leftHeight);

        int rightHeight = avlTree.rightHeight();
        System.out.println("right height===" + rightHeight);
    }
}

class AVLTree {

    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int leftHeight() {
        return root.leftHeight();
    }

    public int rightHeight() {
        return root.rightHeight();
    }
}


class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //计算树的高度
//    public int height() {
//
//    }

    //计算树的左节点的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //计算树的左节点的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    // 返回 以该结点为根结点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


}
