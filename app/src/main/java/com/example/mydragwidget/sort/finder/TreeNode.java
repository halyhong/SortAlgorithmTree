package com.example.mydragwidget.sort.finder;

import android.util.Log;

import java.util.List;

public class TreeNode {
    int data;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        data = x;
    }

    public static final String TAG = "TreeNode";
    public static void main() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;

        B.parent = A;
        C.parent = A;


        Log.d(TAG, "common root data = " + lowestCommonAncestor(A, D, E).data);

        // 二叉搜索树
        A = new TreeNode(4);
        B = new TreeNode(2);
        C = new TreeNode(3);
        D = new TreeNode(1);
        E = new TreeNode(3);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;

        B.parent = A;
        C.parent = A;
        D.parent = B;
        E.parent = B;

        Log.d(TAG, "common root data2 = " + lowestCommonAncestor(A, D, E).data);
        Log.d(TAG, "avl common root data = " + lowestAvlCommonAnces(A, D, E).data);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static TreeNode lowestAvlCommonAnces(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }

        if ((root.data - p.data)*(root.data - q.data) > 0) {
            // 说明 p、q就在同一侧的子树
            if (root.data - p.data > 0) {
                return lowestAvlCommonAnces(root.left, p, q);
            } else {
                return lowestAvlCommonAnces(root.right, p, q);
            }
        }

        return root;
    }

    // 后序遍历
    public static List<TreeNode> btPostAfter(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return res;
        }

        btPostAfter(root.left, res);
        btPostAfter(root.right, res);
        res.add(root);

        return res;
    }

    // 中序遍历
    public static List<TreeNode> btPostMid(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return res;
        }

        btPostMid(root.left, res);
        res.add(root);
        btPostMid(root.right, res);

        return res;
    }

    // 前序遍历
    public static List<TreeNode> btPostBefore(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return res;
        }

        res.add(root);
        btPostBefore(root.left, res);
        btPostBefore(root.right, res);

        return res;
    }
}
