// lint 242
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ConvertBinaryTreetoLinkedListsbyDepth {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
  public List<ListNode> binaryTreeToLists(TreeNode root) {
    List<ListNode> result = new ArrayList();
    
    if (root == null) {
      return result;
    }
    
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      
      ListNode pre = new ListNode(0);
      ListNode dummy = pre;

      for (int i = 0; i < size; i++) {
        
        TreeNode curr = queue.poll();
        System.out.println(curr.val);
        ListNode node = new ListNode(curr.val);
        
        pre.next = node;
        pre = node;
        
        if (curr.left != null) {
          queue.offer(curr.left);
        }
                
        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }
      
      result.add(dummy.next);
    
    }
    return result;
  }
}