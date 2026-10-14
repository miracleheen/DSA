class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Deque<Character> dub = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); ++i){
            if(!dub.isEmpty() && dub.peekFirst() == s.charAt(i)){
                dub.pop();
            }else{
                dub.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!dub.isEmpty()) {
            sb.append(dub.pollLast());
        }

        return sb.toString();
    }
}
