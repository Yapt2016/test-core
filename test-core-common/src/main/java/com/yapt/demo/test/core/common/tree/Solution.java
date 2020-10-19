package com.yapt.demo.test.core.common.tree;

/**
 * @author hurui
 * @version Id: Solution.java, v 0.1 2020/9/26 13:49 YaphetS Exp $$
 */
public class Solution {

    /**
     * 递归反转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        //交换
        TreeNode tn = root.left;
        root.left = root.right;
        root.right = tn;
        if(root.left != null){
            root.left = invertTree(root.left);
        }
        if(root.right != null){
            root.right = invertTree(root.right);
        }
        return root;
    }
}