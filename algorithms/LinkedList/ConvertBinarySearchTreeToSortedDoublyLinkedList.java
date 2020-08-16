// lc 426 思路与 lin378 ConvertBinaryTreeToDoublyLinkedList 类似
// time o（n）  space o（n） n is number of nodes in the tree
// 二叉树遍历的递归实现，每个结点只需遍历一次，故时间复杂度为O(n)。
// 而使用了递归，最差情况下递归调用的深度为O(n)，所以空间复杂度为O(n)。
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        PairMinMax result = inOrderTraverse(root);
        result.lMst.left = result.rMst;
        result.rMst.right = result.lMst;
        return result.lMst;
    }
    
    private PairMinMax inOrderTraverse(Node root) {
        if (root == null) return new PairMinMax();
        PairMinMax leftSub = inOrderTraverse(root.left);
        if (leftSub.rMst != null) {
            root.left = leftSub.rMst;
            leftSub.rMst.right = root;  
        }
        PairMinMax rightSub = inOrderTraverse(root.right);
        if (rightSub.lMst != null) {
            root.right = rightSub.lMst;
            rightSub.lMst.left = root;
        }
        PairMinMax cur = new PairMinMax();
        cur.lMst = leftSub.lMst == null ? root : leftSub.lMst;
        cur.rMst = rightSub.rMst == null ? root : rightSub.rMst;
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