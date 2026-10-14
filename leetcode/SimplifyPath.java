/**
 * SimplifyPath
 */
class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        for (String p : path.split("/")) {
            if (p.equals("") || p.equals("."))
                continue;
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        while (!stack.isEmpty()) {
            res.append("/").append(stack.pollLast());
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}