/**
 * ValidParentheses
 */
class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> pair = Map.of(
            '{', '}',
            '(', ')',
            '[', ']'
        );

        Deque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray()){ 
            if(pair.containsKey(ch)){ 
                stack.push(ch); 
            } else { //]})
                if(stack.isEmpty()){
                    return false;
                }

                Character prev = stack.pop();
                if(pair.get(prev) != ch) return false;
            }
          
        }

        return stack.isEmpty();
    }
}