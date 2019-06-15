package src.algorithms.String;
// 如果经常要修改 String 可以先用 StringBuilder, 修改完多次之后， toString() method
//public class Solution606 {
//    public static String tree2str(TreeNode t) {
//        if (t==null) return "";
//        StringBuilder res = new StringBuilder(t.val+"");
//        String l = tree2str(t.left);
//        String r = tree2str(t.right);
//        
//        if(!l.equals("")&&!r.equals("")) {
//        	return res.append("("+l+")"+"("+r+")").toString();
//        }
//        else if(l.equals("")&&!r.equals("")) {
//        	return res.append("()"+"("+r+")").toString();
//        }
//        else if(!l.equals("")&&r.equals("")) {
//        	return res.append("("+l+")").toString();
//        }
//        else return res.toString();
//    }
//}
class Solution606 {
    public static String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        // if(t==null) return sb.append("()").toString();
        helper(t, sb);
        return sb.toString();
    }
    private static void helper(TreeNode root, StringBuilder sb){
        if(root != null){
            sb.append(root.val);
            if(root.left!=null||root.right !=null){
            sb.append("(");
            helper(root.left,sb);
            sb.append(")");
            if(root.right!=null){
            sb.append("(");
            helper(root.right,sb);
            sb.append(")");}}
        }
    }
}