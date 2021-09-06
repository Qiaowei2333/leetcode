// lc 235, lca in bst
// O(logn)
public class LowestCommonAncestorOfABST {
    // 如果p q可能不在tree里面，lowestCommonAncestor 返回null 意味着不存在lca，p或者q至少一个不在tree里面
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
        // 确保 p <= q
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        
        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else { // 此时 p.val <= root.val <= q.val
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
        // 假如 target找不到，root会一直遍历到null，此时返回false
        if (root == null) return false;
        
        if (root.val == target.val) return true;
        else if (root.val > target.val) 
            return searchNode(root.left, target);
        else 
            return searchNode(root.right, target);
    }
}
