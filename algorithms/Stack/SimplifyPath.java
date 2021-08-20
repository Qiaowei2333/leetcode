// lc 71 https://www.youtube.com/watch?v=SxuGQnlsXcw&ab_channel=JacobHuang
// 看下视频理解下题目意思，这题目简单，就是意思有点绕
import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");

        for(int i = 0; i < arr.length; i++){
            String curr = arr[i].trim();
            if(curr.length() == 0 || curr.equals(".")) continue;

            if(curr.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(curr);
            }
        }

        String res = "";

        for (String s : stack) {
            res += "/" + s;
        }

        return res.equals("") ? "/" : res;
    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        String res = s.simplifyPath("/.../   / /home//foo//");
        System.out.println(res);
    }
}
