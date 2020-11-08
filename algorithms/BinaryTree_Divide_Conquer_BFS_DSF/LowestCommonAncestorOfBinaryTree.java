// lint88
// https://www.youtube.com/watch?v=13m9ZCB8gjw
// time O(n)
public class LowestCommonAncestorOfBinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
          this.val = val;
        }
    }

// 1. root.left 的LCA 存在并且 root.right的LCA存在， 返回root
// 2. root.left 的LCA 和 root.right的LCA只有一个存在，返回存在的那一个
// 3. root.left 的LCA 和 root.right的LCA都不存在， 返回null
// 4. 注意root本身是p或者q时，root自己就是LCA的结果，直接返回

// sol1 此解法前提条件是p q一定存在tree 里面
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        return left == null ? right : left;
        // if (left != null && right == null) {
        //     return left;
        // }

        // if (left == null && right != null) {
        //     return right;
        // }

        // return null;
    }

// sol2 如果p q可能不在tree里面， 解法如下： lowestCommonAncestor1 返回null 意味着不存在，p或者q至少一个不在tree里面
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) { 
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        
        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            boolean pFinded = searchNode(root, p);
            boolean qFinded = searchNode(root, q);
            if (pFinded && qFinded) {
                return root;
            }
            else {
                return null;
            }
        }
    }

    private boolean searchNode(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        else if (root.val > target.val) 
            return searchNode(root.left, target);
        else 
            return searchNode(root.right, target);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        node5.left = node9;

        TreeNode node10 = new TreeNode(11);

        LowestCommonAncestorOfBinaryTree s = new LowestCommonAncestorOfBinaryTree();
        TreeNode ancestor = s.lowestCommonAncestor1(node1, node2, node10);
        System.out.println(ancestor.val);
    }
}