// lc 426 思路与 lin378 ConvertBinaryTreeToDoublyLinkedList 类似
// time o（n）  space o（n） n is number of nodes in the tree
// 二叉树遍历的递归实现，每个结点只需遍历一次，故时间复杂度为O(n)。
// 而使用了递归，最差情况下递归调用的深度为O(n)，所以空间复杂度为O(n)。
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        PairMinMax res = convert(root);
        res.lMst.left = res.rMst;
        res.rMst.right = res.lMst;
        return res.lMst;
    }
    
    private PairMinMax convert(Node root) {
        if (root == null) return null;
        PairMinMax leftList = convert(root.left);
        if (leftList != null) {
            Node rMst = leftList.rMst;
            rMst.right = root;
            root.left = rMst;
        }
        PairMinMax rightList = convert(root.right);
        if (rightList != null) {
            Node lMst = rightList.lMst;
            lMst.left = root;
            root.right = lMst;
        }
        PairMinMax cur = new PairMinMax();
        cur.lMst = root.left == null ? root : leftList.lMst;
        cur.rMst = root.right == null ? root : rightList.rMst;
        return cur;
    }
    
    static class PairMinMax {
        Node lMst;
        Node rMst;
        public PairMinMax() {}
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}