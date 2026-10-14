class RemovingStarsFromAString {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && ch == '*'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()){
            res.append(stack.pollLast());
        }

        return res.toString();
    }
}
