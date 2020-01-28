// lt 7
import java.util.*;

public class SerializeandDeserializeBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    /**
     * This method will be invoked first, you should design your own algorithm to
     * serialize a binary tree which denote by a root node to a string which can be
     * easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        
    }

    /**
     * This method will be invoked second, the argument data is what exactly you
     * serialized at method "serialize", that means the data is not given by system,
     * it's given by your own serialize method. So the format of data is designed by
     * yourself, and deserialize it here as you serialize it in "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
    }
}