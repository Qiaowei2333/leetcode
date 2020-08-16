// lin378
public class ConvertBinaryTreeToDoublyLinkedList {
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        NodePair result = inOrderTraverse(root);
        return result.min;
    }
    
    private NodePair inOrderTraverse(TreeNode root) {
        if (root == null) return new NodePair();

        NodePair left = inOrderTraverse(root.left);
        DoublyListNode curNode = new DoublyListNode(root.val);
        if (left.max != null) {
            curNode.prev = left.max;
            left.max.next = curNode;

        }
        NodePair right = inOrderTraverse(root.right);
        if (right.min != null) {
            curNode.next = right.min;
            right.min.prev = curNode;
        }
        NodePair cur = new NodePair();
        cur.min = left.min == null ? curNode : left.min;
        cur.max = right.max == null ? curNode : right.max;
        return cur;
    }
    
    static class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    static class NodePair {
        DoublyListNode min;
        DoublyListNode max;
        public NodePair() {}
        public NodePair(DoublyListNode min, DoublyListNode max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        ConvertBinaryTreeToDoublyLinkedList s = new ConvertBinaryTreeToDoublyLinkedList();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        DoublyListNode result = s.bstToDoublyList(node1);
        System.out.println(result.val);
    }
}