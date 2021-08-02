package _Stack;

import java.util.Stack;

public class _71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] subPaths = path.split("/+");
        Stack<String> stk = new Stack<>();

        if (subPaths.length == 0) {
            return "/";
        }

        for (String p : subPaths) {
            if (p.length() == 0) {
                continue;
            }
            if (p.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
                continue;
            }
            if (p.equals(".")) {
                continue;
            }
            stk.add(p);
        }
        // home foo
        // /home/foo
        String res = "";
        while (!stk.isEmpty()) {
            res = "/" + stk.pop() + res;
        }

        return res;
    }

    public static void main(String[] args) {
        _71_SimplifyPath sp = new _71_SimplifyPath();
        String str = "/a/./b/../../c";
        String ans = sp.simplifyPath(str);
        System.out.println(ans);
    }
}
