package com.txwdd.lettcode;

/**
 * 翻转二叉树
 * <p>
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Tree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);


        root.preOrder(root);

        System.out.println();
        TreeNode invert = invert(root);
        invert.preOrder(invert);
    }

    private static TreeNode invert(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode right = invert(root.right);
        TreeNode left = invert(root.left);

        root.left=right;
        root.right=left;
        return root;

    }
}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.value = val;
    }


    public void preOrder(TreeNode treeNode){
        if(treeNode ==null){
            return;
        }
        System.out.print(treeNode.value+"-->");
        TreeNode left = treeNode.left;
        preOrder(left);

        TreeNode right = treeNode.right;
        preOrder(right);
    }


}
